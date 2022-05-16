package medium;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    /*
    Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix.
    If there is no clear path, return -1.

    A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell
    (i.e., (n - 1, n - 1)) such that:

    All the visited cells of the path are 0.
    All the adjacent cells of the path are 8-directionally connected
     (i.e., they are different and they share an edge or a corner).

    The length of a clear path is the number of visited cells of this path.
     */
    public static void main(String[] args) {
        System.out.println(shortestPathBinaryMatrix(new int[][]{{0, 1}, {1, 0}}));
    }


    public static int shortestPathBinaryMatrix(int[][] grid) {


        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();

        if (grid[0][0] == 1) return -1;
        q.add(new int[]{0, 0});
        int steps = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        boolean found = false;

        while (!q.isEmpty() && !found) {
            steps++;
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int[] polled = q.poll();
                int x = polled[0];
                int y = polled[1];
                if (x == grid.length - 1 && y == grid[0].length - 1) {
                    found = true;
                }
                if (visited[x][y]) continue;
                visited[x][y] = true;
                for (int d = 0; d < dirs.length; d++) {
                    if (isValid(dirs[d], x, y, grid)) q.offer(new int[]{x + dirs[d][0], y + dirs[d][1]});
                }
            }

        }
        return (found ? steps : -1);

    }


    private static boolean isValid(int[] dir, int x, int y, int[][] grid) {

        if (x + dir[0] < 0) return false;
        if (x + dir[0] >= grid.length) return false;
        if (y + dir[1] < 0) return false;
        if (y + dir[1] >= grid.length) return false;
        if (grid[x + dir[0]][y + dir[1]] != 0) return false;
        return true;

    }
}
