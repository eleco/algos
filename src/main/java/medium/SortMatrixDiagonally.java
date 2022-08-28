package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortMatrixDiagonally {

    /*
    Given an m x n matrix mat of integers,
    sort each matrix diagonal in ascending order and return the resulting matrix.
    */

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                diagonalSort(new int[][]{ {3,3,1,1}, {2,2,1,2}, {1,1,1,2}})));
    }


    static int[][] diagonalSort(int[][] mat) {

        Map<Integer, PriorityQueue<Integer>> diagonals = new HashMap<>();

        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[0].length;j++) {
                diagonals.putIfAbsent(i-j, new PriorityQueue<>());
                diagonals.get(i-j).offer(mat[i][j]);
            }
        }

        for  (int i=0;i<mat.length;i++) {
            for (int  j=0;j<mat[0].length;j++) {
                mat[i][j] = diagonals.get(i-j).poll();
            }
        }

        return mat;

    }
}

