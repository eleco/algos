package medium;

public class NumberOfIslands_dfs {
    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by water.

    public static void main(String args[]) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    public static  int numIslands(char[][] grid) {
        int island = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                if (grid[j][i] == '1') {
                    island++;
                    dfs(j, i, grid);
                }
            }
        }
        return island;
    }


    static void dfs(int j, int i, char[][] grid) {

        if (j < 0 || i < 0) return;
        if (j > grid.length - 1 || i > grid[0].length - 1) return;
        char c = grid[j][i];

        if (c != '1') return;

        grid[j][i] = '2';

        dfs(j - 1, i, grid);
        dfs(j, i - 1, grid);
        dfs(j + 1, i, grid);
        dfs(j, i + 1, grid);
    }
}
