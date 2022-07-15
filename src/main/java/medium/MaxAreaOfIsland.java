package medium;

public class MaxAreaOfIsland {

    /*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
     connected 4-directionally (horizontal or vertical.) You may assume all four edges of
     the grid are surrounded by water.

    The area of an island is the number of cells with a value 1 in the island.

    Return the maximum area of an island in grid. If there is no island, return 0.
     */

    public static void main(String[] args) {
        System.out.println(maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }


    static int maxAreaOfIsland(int[][] grid) {

        int max =0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[0].length;j++) {
                if (grid[i][j]!=0)    max=Math.max(max, dfs(grid,i,j));
            }
        }
        return max;
    }


    static int dfs (int[][] grid, int y, int x) {

        if (y<0 || x<0 || y>=grid.length || x>=grid[0].length) return 0;
        if (grid[y][x]==0) return 0;

        grid[y][x]=0;

        int q1 = dfs(grid, y-1, x);
        int q2 = dfs(grid, y+1, x);
        int q3 =  dfs(grid, y, x-1);
        int q4 =  dfs(grid, y, x+1);
        int area = 1+ q1 +q2 +q3 +q4;
        return area;
    }


}
