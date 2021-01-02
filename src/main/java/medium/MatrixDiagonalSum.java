package medium;

import java.util.Arrays;

public class MatrixDiagonalSum {


    /*
    Given a square matrix mat, return the sum of the matrix diagonals.
    Only include the sum of all the elements on the primary diagonal and all the elements
    on the secondary diagonal that are not part of the primary diagonal.
     */
    public static void main(String[] args) {
        System.out.println(diagonalSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }

    public static int diagonalSum(int[][] mat) {
        if (mat==null || mat.length==0) return 0;
        int s1 = 0;
        int s2=0;
        for (int i=0;i<mat.length; i++)  {
            s1+=mat[i][i];
            if (i!=mat[0].length-i-1) {
                s2+=mat[i][mat[0].length-i-1];
            }
        }

        return s1+s2;
    }
}
