package medium;

import java.util.Arrays;

public class OutOfBoundaryPaths {
    /*
    There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn].
    You are allowed to move the ball to one of the four adjacent cells in the grid
    (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.

    Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball
    out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
     */

    public static void main(String[] args) {
        System.out.println(findPaths(2,2,2,0,0));
    }

    static int mod = 1000000007;
    static long [][][] mem;
    static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        mem = new long [51][51][51];
        for (long[][] longs : mem) {
            for (long[] aLong : longs) {
                Arrays.fill(aLong, -1L);
            }
        }

        return  (int) (dfs(m,n,maxMove,startRow, startColumn, 0)%mod);
    }

    static long dfs(int m, int n, int maxMove, int y, int x, int curMoves) {
        if (curMoves>maxMove) {
            return 0;
        }

        if (isOut(m,n,x,y)) return 1;

        if (mem[y][x][curMoves]!=-1) return mem[y][x][curMoves];

        long ret =
                dfs(m,n,maxMove, y-1, x, curMoves+1)%mod +
                        dfs(m,n,maxMove, y+1, x, curMoves+1)%mod +
                        dfs(m,n,maxMove, y, x+1, curMoves+1)%mod +
                        dfs(m,n,maxMove, y, x-1, curMoves+1)%mod ;

        mem[y][x][curMoves] = ret;
        return ret;
    }

    static boolean isOut(int m, int n, int x, int y) {
        return (y<0 || x<0 || x>=n || y>=m);
    }
}
