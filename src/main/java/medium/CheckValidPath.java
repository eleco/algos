package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckValidPath {

    /*
        Given a m x n grid. Each cell of the grid represents a street. The street of grid[i][j] can be:

            1 which means a street connecting the left cell and the right cell.
            2 which means a street connecting the upper cell and the lower cell.
            3 which means a street connecting the left cell and the lower cell.
            4 which means a street connecting the right cell and the lower cell.
            5 which means a street connecting the left cell and the upper cell.
            6 which means a street connecting the right cell and the upper cell.

     */

    static Map<String, int[]> dirs = new HashMap<>();
    static Map<Integer, Set<String>> transitions = new HashMap<>();

    static {
        dirs.put("E", new int[]{1, 0});
        dirs.put("W", new int[]{-1, 0});
        dirs.put("N", new int[]{0, -1});
        dirs.put("S", new int[]{0, 1});


        transitions.put(1, Set.of("E", "W"));
        transitions.put(2, Set.of("N", "S"));
        transitions.put(3, Set.of("E", "N"));
        transitions.put(4, Set.of("W", "N"));
        transitions.put(5, Set.of("S", "E"));
        transitions.put(6, Set.of("S", "W"));
    }


    public static void main(String[] args) {
        System.out.println(hasValidPath(new int[][]{{2},{2},{2},{2},{2},{2}, {2},{6}}));
    }


    public static boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(0, 0, grid, visited);
    }


    static boolean dfs(int x, int y, int[][] grid, boolean[][] visited) {

        if (y == grid.length - 1 && x == grid[0].length - 1) {
            return true;
        }

        if (visited[y][x]) return false;
        visited[y][x] = true;


        int c = grid[y][x];

        if (c == 1) {
            return move(x, y, "W", grid, visited) || move(x, y, "E", grid, visited);
        }
        if (c == 2) {
            return move(x, y, "N", grid, visited) || move(x, y, "S", grid, visited);
        }
        if (c == 3) {
            return move(x, y, "W", grid, visited) || move(x, y, "S", grid, visited);
        }
        if (c == 4) {
            return move(x, y, "E", grid, visited) || move(x, y, "S", grid, visited);
        }
        if (c == 5) {
            return move(x, y, "N", grid, visited) || move(x, y, "W", grid, visited);
        }
        if (c == 6) {
            return move(x, y, "N", grid, visited) || move(x, y, "E", grid, visited);
        }
        return false;

    }

    private static boolean move(int x, int y, String dir, int[][] grid, boolean[][] visited) {


        int[] d = dirs.get(dir);
        x = x + d[0];
        y = y + d[1];

        if (x < 0 || y < 0 || y > grid.length - 1 || x > grid[0].length - 1) {
            return false;
        }

        Set s = transitions.get(grid[y][x]);
        return (s.contains(dir)) && dfs(x, y, grid, visited);
    }

}
