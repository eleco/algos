package medium;

public class PathWithMaximumGold {


    /*
    In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell,
    0 if it is empty.

    Return the maximum amount of gold you can collect under the conditions:

    Every time you are located in a cell you will collect all the gold in that cell.
    From your position you can walk one step to the left, right, up or down.
    You can't visit the same cell more than once.
    Never visit a cell with 0 gold.
    You can start and stop collecting gold from any position in the grid that has some gold.
     */

    public static void main(String args[]) {
        System.out.println(getMaximumGold(new int[][]{{0,6,0}, {5,8,7}, {0,9,0}}));
    }


    static int[][] visited = null;

    public static int getMaximumGold(int[][] grid) {

        int max = 0;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, dfs(i, j, grid, 0));
                }
            }
        }
        return max;
    }


    public static int dfs(int i, int j, int[][] grid, int max) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return max;

        }
        if (visited[i][j] == 1) {
            return max;
        }

        max = max + grid[i][j];

        visited[i][j] = 1;
        int a = dfs(i - 1, j, grid, max);
        int b = dfs(i + 1, j, grid, max);
        int c = dfs(i, j - 1, grid, max);
        int d = dfs(i, j + 1, grid, max);
        visited[i][j] = 0;
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
