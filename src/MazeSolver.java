import java.util.ArrayList;
public class MazeSolver {
    public ArrayList<String> pathCoordinates(String[][] maze){
        ArrayList<String> coords = new ArrayList<String>();
        boolean found = false;
        int r = 0;
        int c = 0;
        while (!found && r < maze.length){
            if (maze[r][c].equals(".")) {
                coords.add(returnAsCoords(r+1, c+1));
                maze[r][c] = "#";
                
                if (maze[r + 1][c] == ".") r = r+1;
                else if (maze[r][c + 1] == ".") c = c+1;
            }
            if (c == maze[0].length - 1 && r == maze.length - 1) found = true;
            else {
                if (c == maze[0].length - 1) c = 0;
                else {
                    c++;
                }
                r++;
            }
        }
        return coords;
    }

    public String returnAsCoords(int x, int y){
        return ("(" + x +", " + y + ")");
    }
}
