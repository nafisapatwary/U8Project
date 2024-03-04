import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        String[][] test1 = getMaze("Data/Maze");
        MazeSolver m = new MazeSolver();

        String[][] test2 = {{".", ".", "."},
                            {"#", "#", "."},
                            {"#", ".", "."},
                            {"#", ".", "#"},
                            {"#", ".", "."}};


        System.out.println(
                "[(0, 0), (0, 1), (0, 2), (0, 3), (1, 3), (2, 3), (3, 3), (4, 3), (4, 2), (4, 1), (4, 0), (5, 0), (6, 0), (6, 1), (6, 2), (6, 3), (6, 4), (6, 5), (6, 6), (6, 7), (6, 8), (6, 9), (6, 10), (6, 11), (6, 12), (6, 13), (6, 14), (6, 15), (6, 16), (5, 16), (4, 16), (3, 16), (2, 16), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (1, 21), (1, 22), (1, 23), (1, 24), (2, 24), (3, 24), (4, 24), (5, 24), (6, 24), (7, 24), (7, 23), (7, 22), (7, 21), (8, 21), (9, 21), (9, 22), (9, 23), (9, 24), (9, 25), (9, 26)]");
        System.out.println(m.pathCoordinates(test1));

    }
    public static String[][] getMaze(String fileName) {
        File f = new File(fileName);
        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        }

        ArrayList<String> fileData = new ArrayList<String>();
        while (s.hasNextLine())
            fileData.add(s.nextLine());

        int rows = fileData.size();
        int cols = fileData.get(0).length();

        String[][] maze = new String[rows][cols];

        for (int i = 0; i < fileData.size(); i++) {
            String d = fileData.get(i);
            for (int j = 0; j < d.length(); j++) {
                maze[i][j] = d.charAt(j) + "";
            }
        }
        return maze;

    }

}