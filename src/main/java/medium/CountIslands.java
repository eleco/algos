package medium;

import java.util.LinkedList;
import java.util.Queue;

public class CountIslands {


    /*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

    Example 1:

    Input: grid = [
      ["1","1","1","1","0"],
      ["1","1","0","1","0"],
      ["1","1","0","0","0"],
      ["0","0","0","0","0"]
    ]
    Output: 1
     */

    static Queue<int[]> q = new LinkedList<int[]>();

    static boolean[][] visited;

    public static void main(String args[]) {
        System.out.println(numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}}
        ));
    }


    public static int numIslands(char[][] grid) {

        if (grid.length == 0) return 0;

        visited = new boolean[grid.length][grid[0].length];

        int islands = 0;


        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[j].length; i++) {

                if (grid[j][i] == '1' && !visited[j][i]) {
                    visit(j, i, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void visit(int j, int i, char[][] grid) {

        q.add(new int[]{j, i});
        while (!q.isEmpty()) {

            int[] a = q.poll();
            int y = a[0];
            int x = a[1];

            if (x < 0 || y < 0 || y >= grid.length || x >= grid[j].length) continue;

            if (grid[y][x] == '0') continue;

            if (visited[y][x]) continue;
            visited[y][x] = true;

            q.offer(new int[]{y - 1, x});
            q.offer(new int[]{y + 1, x});
            q.offer(new int[]{y, x - 1});
            q.offer(new int[]{y, x + 1});
        }
    }
}
