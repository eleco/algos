package medium;

import java.util.PriorityQueue;

public class PathWithMinimumEffort {


    /*
    You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
    A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
    Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
     */

    public static void main(String[] args) {
        System.out.println(minimumEffortPath(new int[][]{{1,2,3}, {3,8,4}, {5,3,5}}));
    }

    public static int minimumEffortPath(int[][] heights) {

        int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int[][] costs = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                costs[i][j] = Integer.MAX_VALUE;
            }
        }


        PriorityQueue<int[]> q = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[2], b[2]));
        q.add(new int[]{0, 0, 0});

        while (!q.isEmpty()) {

            int[] h = q.poll();
            int x = h[0];
            int y = h[1];
            int c = h[2];

            if (x == heights.length - 1 && y == heights[0].length - 1) {
                return c;
            }

            int nx = 0;
            int ny = 0;
            for (int d = 0; d < dirs.length; d++) {
                nx = x + dirs[d][0];
                ny = y + dirs[d][1];

                if (nx < 0 || nx >= heights.length || ny < 0 || ny >= heights[0].length) {
                    continue;
                }
                int effort = Math.max(c, Math.abs(heights[nx][ny] - heights[x][y]));
                if (costs[nx][ny] > effort) {
                    costs[nx][ny] = effort;
                    q.offer(new int[]{nx, ny, costs[nx][ny]});
                }

            }
        }
        return 0;
        }

}
