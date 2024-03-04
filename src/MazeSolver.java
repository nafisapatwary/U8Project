import java.util.ArrayList;
public class MazeSolver {
    public ArrayList<String> pathCoordinates(String[][] maze){
        ArrayList<String> coords = new ArrayList<String>();
        boolean found = false;
        int r = 0;
        int c = 0;
        while (!found){
            if (c == maze[0].length - 1 && r == maze.length - 1) found = true;
            if (maze[r][c].equals(".")) {
                coords.add(returnAsCoords(r, c));
                //make it so there's no chance of going back to an already found spot
                maze[r][c] = "#";
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
}
