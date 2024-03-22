import java.util.ArrayList;
public class MazeSolver {
    private String[][] maze;
    private ArrayList<String> coords = new ArrayList<String>();

    public MazeSolver(String[][] maze){
        this.maze = maze;
    }

    public ArrayList<String> pathCoordinates(){
        boolean found = false;
        int r = 0;
        int c = 0;
        while (!found){
            if (c == maze[0].length - 1 && r == maze.length - 1) found = true;
            if (maze[r][c].equals(".")) {
                //mark as visited
                coords.add(returnAsCoords(r, c));
                maze[r][c] = "V";
                //check for dead ends, if dead, place with X and reset to beginning of the maze
                if (isDeadEnd(r, c)){
                    maze[r][c] = "X";
                    reset();
                    r = 0;
                    c = 0;
                }
                boolean moved = false;
                //needs to check all directions
                if (r != maze.length - 1) {
                    if (maze[r + 1][c].equals(".") && !moved) {
                        r++;
                        moved = true;
                    }
                }
                if (r != 0){
                    if (maze[r - 1][c].equals(".") && !moved) {
                        r--;
                        moved = true;
                    }
                }
                if (c != maze[0].length - 1){
                    if (maze[r][c + 1].equals(".") && !moved) {
                        c++;
                        moved = true;
                    }
                }
                if (c != 0){
                    if (maze[r][c-1].equals(".") && !moved) {
                        c--;
                        moved = true;
                    }
                }
            }
        }
        return coords;
    }

    public String returnAsCoords(int x, int y){
        return ("(" + x +", " + y + ")");
    }

    public boolean isDeadEnd(int r, int c){
        int availPaths = 0;
        if (r == maze.length - 1 && c == maze[0].length - 1) return false;
        //checking for middle rows
        if (r > 0 && r < maze.length - 1){
            if (maze[r+1][c].equals(".")) availPaths++;
            if (maze[r-1][c].equals(".")) availPaths++;
            if (c != 0){
                if (maze[r][c-1].equals(".")) availPaths++;
            }
            if (c != maze[0].length - 1){
                if (maze[r][c+1].equals(".")) availPaths++;
            }
        }
        //checking bottom row
        if (r == maze.length - 1){
            if (maze[r - 1][c].equals(".")) availPaths++;
            if (c != 0){
                if (maze[r][c-1].equals(".")) availPaths++;
            }
            if (c != maze[0].length - 1){
                if (maze[r][c+1].equals(".")) availPaths++;
            }
        }

        if (r == 0){
            if (maze[r+1][c].equals(".")) availPaths++;
            if (c != 0){
                if (maze[r][c-1].equals(".")) availPaths++;
            }
            if (c != maze[0].length - 1){
                if (maze[r][c+1].equals(".")) availPaths++;
            }
        }
        if (availPaths == 0){
            return true;
        }
        return false;
    }

    public void printMaze(){
        for (String[] s : maze){
            for (String x: s){
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public void reset() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j].equals("V")) {
                    maze[i][j] = ".";
                }
            }
        }
        //reset coords list
        coords = new ArrayList<String>();
        coords.add("(0, 0)");
    }

}
