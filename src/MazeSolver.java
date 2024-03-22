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
//            printMaze();
//            System.out.println();
            if (c == maze[0].length - 1 && r == maze.length - 1) found = true;
            if (maze[r][c].equals(".")) {
                if (isDeadEnd(r, c)){
                    resetVisited();
                    r = 0;
                    c = 0;
                }
                else{
                    //mark as visited
                    coords.add(returnAsCoords(r, c));
                    maze[r][c] = "V";
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
            printMaze();
            System.out.println();
        }
        return coords;
    }

    public String returnAsCoords(int x, int y){
        return ("(" + x +", " + y + ")");
    }

    public boolean isDeadEnd(int r, int c){
        //help theres too many conditions omg omg mr das hellllllllllllp
    }

    public void printMaze(){
        for (String[] s : maze){
            for (String x: s){
                System.out.print(x);
            }
            System.out.println();
        }
    }

    public void resetVisited() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j].equals("V")) {
                    maze[i][j] = ".";
                }
            }
        }
        //reset coords list
        coords = new ArrayList<String>();
    }

}
