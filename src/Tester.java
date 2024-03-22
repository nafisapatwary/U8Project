import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        //Right now: Super Maze
        String[][] test1 = getMaze("Data/Maze");
        MazeSolver m = new MazeSolver(test1);
        System.out.println(m.pathCoordinates());
//        String[][] test2 = {{".", ".", "."},
//                            {"#", "#", "."},
//                            {"#", ".", "."},
//                            {"#", ".", "#"},
//                            {"#", ".", "."}};

        //Testing purposes
//        System.out.println("[(0, 0), (1, 0), (2, 0), (3, 0), (3, 1), (3, 2), (3, 3), (3, 4), (3, 5), (3, 6), (3, 7), (3, 8), (2, 8), (1, 8), (1, 9), (1, 10), (1, 11), (1, 12), (1, 13), (1, 14), (1, 15), (1, 16), (1, 17), (1, 18), (1, 19), (1, 20), (2, 20), (3, 20), (4, 20), (5, 20), (6, 20), (7, 20), (7, 19), (7, 18), (7, 17), (7, 16), (7, 15), (8, 15), (9, 15), (10, 15), (11, 15), (11, 16), (11, 17), (11, 18), (11, 19), (11, 20), (11, 21), (11, 22), (11, 23), (11, 24), (11, 25), (11, 26), (10, 26), (9, 26), (8, 26), (7, 26), (6, 26), (5, 26), (4, 26), (3, 26), (3, 27), (3, 28), (3, 29), (3, 30), (3, 31), (3, 32), (3, 33), (3, 34), (3, 35), (3, 36), (3, 37), (3, 38), (3, 39), (3, 40), (3, 41), (4, 41), (5, 41), (6, 41), (7, 41), (8, 41), (9, 41), (9, 40), (9, 39), (9, 38), (9, 37), (9, 36,) (9, 35), (10, 35), (11, 35), (12, 35), (13, 35), (14, 35), (14, 36), (14, 37), (14, 38), (14, 39), (14, 40), (14, 41), (14, 42), (14, 43), (14, 44), (14, 45), (14, 46), (15, 46), (16, 46), (17, 46), (18, 46), (19, 46), (20, 46), (20, 45), (20, 44), (20, 43), (20, 42), (20, 41), (20, 40), (20, 39), (20, 38), (20, 37), (20, 36), (21, 36), (22, 36), (23, 36), (23, 35), (23, 34), (23, 33), (23, 32), (23, 31), (23, 30), (23, 29), (23, 28), (23, 27), (23, 26), (23, 25), (23, 24), (23, 23), (23, 22), (23, 21), (22, 21), (21, 21), (20, 21), (20, 20), (20, 19), (20, 18), (20, 17), (20, 16), (20, 15), (20, 14), (20, 13), (20, 12), (20, 11), (20, 10), (20, 9), (21, 9), (22, 9), (23, 9), (24, 9), (25, 9), (26, 9), (26, 10), (26, 11), (26, 12), (26, 13), (26, 14), (26, 15), (26, 16), (26, 17), (26, 18), (26, 19), (26, 20), (26, 21), (26, 22), (26, 23), (26, 24), (26, 25), (26, 26), (26, 27), (26, 28), (26, 29), (26, 30), (27, 30), (28, 30), (29, 30), (30, 30), (31, 30), (32, 30), (33, 30), (33, 31), (33, 32), (33, 33), (33, 34), (33, 35), (33, 36), (33, 37), (33, 38), (33, 39), (33, 40), (33, 41), (33, 42), (33, 43), (33, 44), (33, 45), (33, 46), (33, 47), (33, 48), (33, 49), (33, 50), (33, 51), (33, 52), (33, 53), (33, 54), (33, 55), (33, 56), (32, 56), (31, 56), (30, 56), (29, 56), (28, 56), (27, 56), (26, 56), (25, 56), (25, 57), (25, 58), (25, 59), (25, 60), (25, 61), (25, 62), (25, 63), (25, 64), (25, 65), (25, 66), (25, 67), (25, 68), (25, 69), (25, 70), (25, 71), (26, 71), (27, 71), (28, 71), (29, 71), (30, 71), (31, 71), (32, 71), (33, 71), (34, 71), (35, 71), (36, 71), (36, 72), (36, 73), (36, 74), (36, 75), (36, 76), (36, 77), (36, 78), (36, 79), (36, 80), (36, 81), (37, 81), (38, 81), (39, 81), (40, 81), (41, 81), (41, 80), (41, 79), (41, 78), (41, 77), (41, 76), (41, 75), (41, 74), (41, 73), (41, 72), (41, 71), (41, 70), (41, 69), (41, 68), (41, 67), (41, 66), (41, 65), (41, 64), (41, 63), (42, 63), (43, 63), (44, 63), (45, 63), (46, 63), (46, 62), (46, 61), (46, 60), (46, 59), (46, 58), (46, 57), (46, 56), (46, 55), (46, 54), (46, 53), (46, 52), (46, 51), (46, 50), (46, 49), (46, 48), (46, 47), (46, 46), (46, 45), (46, 44), (47, 44), (48, 44), (48, 45), (48, 46), (48, 47), (48, 48), (48, 49), (48, 50), (48, 51), (48, 52), (48, 53), (48, 54), (48, 55), (48, 56), (48, 57), (48, 58), (48, 59), (48, 60), (48, 61), (48, 62), (48, 63), (48, 64), (48, 65), (48, 66), (48, 67), (48, 68), (48, 69), (48, 70), (48, 71), (48, 72), (48, 73), (48, 74), (47, 74), (46, 74), (45, 74), (44, 74), (44, 75), (44, 76), (44, 77), (44, 78), (44, 79), (44, 80), (44, 81), (44, 82), (44, 83), (44, 84), (44, 85), (44, 86), (44, 87), (44, 88), (44, 89), (44, 90), (44, 91), (44, 92), (44, 93), (44, 94), (45, 94), (46, 94), (47, 94), (47, 95), (47, 96), (47, 97), (47, 98), (47, 99), (47, 100), (47, 101), (47, 102), (47, 103), (47, 104), (47, 105), (47, 106), (47, 107), (47, 108), (47, 109), (47, 110), (47, 111), (47, 112), (48, 112), (49, 112), (49, 113), (49, 114), (49, 115), (49, 116), (49, 117)]");
//        System.out.println(m.pathCoordinates());

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