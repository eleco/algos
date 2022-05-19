package hard;

public class LongestIncreasingPathInMatrix {

    /*
    Given an m x n integers matrix, return the length of the longest increasing path in matrix.

    From each cell, you can either move in four directions: left, right, up, or down.
    You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
     */
    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(
                new int[][]{ {9,9,4}, {6,6,8}, {2,1,1}, {3,4,5}, {3,2,6}, {2,2,1}}
        ));
    }

    public static int longestIncreasingPath(int[][] matrix) {

        int cache[][] = new int[matrix.length][matrix[0].length];

        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(dfs(matrix, i, j, cache), max);
            }
        }
        return max;
    }


    private static int dfs(int[][] m, int i, int j, int[][] cache) {

        if (cache[i][j] != 0) return cache[i][j];
        int tmpMax = 0;
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {

            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni < 0 || nj < 0 || ni >= m.length || nj >= m[0].length) continue;

            if (m[i][j] >= m[ni][nj]) continue;

            cache[ni][nj] = dfs(m, ni, nj, cache);
            tmpMax = Math.max(tmpMax, cache[ni][nj]);
        }
        return 1 + tmpMax;

    }
}
