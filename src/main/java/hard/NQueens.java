package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /*
    The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
     */

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));

    }


    public static List<List<String>> solveNQueens(int n) {


        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        List<List<String>> ret = new ArrayList<>();
        solve(n, board, ret, 0);
        return ret;
    }


    static void solve(int n, char[][] board, List<List<String>> all, int row) {

        if (row == n) {
            List<String> str = new ArrayList();
            for (int i = 0; i < board.length; i++) {
                String s = "";
                for (int j = 0; j < board.length; j++) {
                    s += String.valueOf(board[i][j]);
                }
                str.add(s);
            }
            all.add(str);
            return;
        }


        for (int col = 0; col < n; col++) {
            boolean b = isValid(n, board, col, row);
            if (b) {
                board[row][col] = 'Q';
                solve(n, board, all, row + 1);
                board[row][col] = '.';
            }
        }
    }


    static boolean isValid(int n, char[][] board, int col, int row) {

        for (int i = 0; i < n; i++) {

            if (board[i][col] == 'Q') return false;
            if ((row - i) >= 0 && (col - i) >= 0 && board[row - i][col - i] == 'Q') return false;
            if ((row + i) < n && (col + i) < n && board[row + i][col + i] == 'Q') return false;
            if ((row - i) >= 0 && (col + i) < n && board[row - i][col + i] == 'Q') return false;
            if ((row + i) < n && (col - i) >= 0 && board[row + i][col - i] == 'Q') return false;

        }
        return true;

    }
}
