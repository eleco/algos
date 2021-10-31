package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumberInAMatrix {


    /*
    Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

    A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.
     */

    public static void main(String[] args) {
        System.out.println(luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}}));
    }

    static List<Integer> luckyNumbers(int[][] matrix) {

        int minrow[] = new int[matrix.length];
        int maxcol[] = new int[matrix[0].length];

        Arrays.fill(minrow, Integer.MAX_VALUE);

        for (int y = 0; y < matrix.length; y++) {

            for (int x = 0; x < matrix[y].length; x++) {
                minrow[y] = Math.min(matrix[y][x], minrow[y]);
                maxcol[x] = Math.max(matrix[y][x], maxcol[x]);

            }
        }

        List<Integer> l = new ArrayList<>();
        for (int y = 0; y < matrix.length; y++) {

            for (int x = 0; x < matrix[y].length; x++) {
                if (matrix[y][x] == minrow[y] && matrix[y][x] == maxcol[x]) {
                    l.add(matrix[y][x]);
                }
            }
        }

        return l;
    }
}

