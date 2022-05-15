package easy;

public class IslandPerimeter {

    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }

    public static int islandPerimeter(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, visited);
                }
            }
        }
        return 0;
    }


    public static int dfs(int[][] g, int i, int j, boolean[][] visited) {


        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length) return 0;

        if (g[i][j] == 0) return 0;

        if (visited[i][j]) return 0;


        visited[i][j] = true;

        int count = 0;

        if (i > 0 && g[i - 1][j] == 0) count++;
        if (j > 0 && g[i][j - 1] == 0) count++;
        if (i < g.length - 1 && g[i + 1][j] == 0) count++;
        if (j < g[0].length - 1 && g[i][j + 1] == 0) count++;

        if (i == 0) count++;
        if (i == g.length - 1) count++;
        if (j == 0) count++;
        if (j == g[0].length - 1) count++;

        return count + dfs(g, i - 1, j, visited) + dfs(g, i + 1, j, visited) + dfs(g, i, j - 1, visited) + dfs(g, i, j + 1, visited);
    }
}
