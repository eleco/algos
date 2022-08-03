package medium;

public class UniquePaths {

    /*

    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there?
     */

    public static void main(String[] args) {
        System.out.println(uniquePaths_dp(3, 4));
        System.out.println(uniquePaths_dfs(3, 4));
    }

    static int uniquePaths_dp(int m, int n) {

        int[][] a = new int[m][n];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (j == 0 && i == 0) a[j][i] = 1;
                else if (j == 0) {
                    a[j][i] = a[j][i - 1];
                } else if (i == 0) {
                    a[j][i] = a[j - 1][i];
                } else a[j][i] = a[j - 1][i] + a[j][i - 1];

            }
        }
        return a[m - 1][n - 1];
    }

    static int[][] memo;

    static int uniquePaths_dfs(int m, int n) {
        memo = new int[m][n];
        return dfs(m, n, 0, 0);
    }

    static int dfs(int m, int n, int x, int y) {

        if (y >= m || x >= n) return 0;

        if (y == m - 1 && x == n - 1) {
            return 1;
        }

        if (memo[y][x] != 0) return memo[y][x];

        int count = dfs(m, n, x + 1, y) + dfs(m, n, x, y + 1);
        memo[y][x] = count;
        return count;
    }

}
