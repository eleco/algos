package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberOfIslands {


    //Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    // You may assume all four edges of the grid are all surrounded by water.

    public static void main(String args[]) {
        char[][] grid = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid));
    }

    static Set<Cell> visited = new HashSet<Cell>();

    public static int numIslands(char[][] grid) {
        visited = new HashSet<Cell>();
        int num = 0;
        for (int j = 0; j < grid.length; j++) {
            for (int i = 0; i < grid[0].length; i++) {
                Cell c = new Cell(i, j);
                if (visited.contains(c)) continue;
                if (grid[j][i] == '1') {
                    bfs(c, grid, grid[0].length, grid.length);
                    num++;
                }
            }
        }
        return num;
    }

    public static void bfs(Cell c, char[][] grid, int maxX, int maxY) {
        Queue<Cell> q = new LinkedList<Cell>();
        q.add(c);
        while (!q.isEmpty()) {
            Cell t = q.poll();
            if (t.x >= 0 && t.y >= 0 && t.x < maxX && t.y < maxY && !visited.contains(t) && grid[t.y][t.x] == '1') {

                visited.add(t);
                q.add(new Cell(t.x - 1, t.y));
                q.add(new Cell(t.x + 1, t.y));
                q.add(new Cell(t.x, t.y + 1));
                q.add(new Cell(t.x, t.y - 1));
            }
        }
    }

    static class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return 7 * x + 31 * y;
        }

        public boolean equals(Object o) {
            return x == ((Cell) o).x && y == ((Cell) o).y;
        }
    }

}
