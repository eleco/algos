package medium;

public class SearchA2DMatrixII {
    /*
    Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.


     */


    public static void main(String[] args) {
        System.out.println(searchMatrix(
                new int[][]{{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}},5));
    }

   static boolean searchMatrix(int[][] matrix, int target) {

        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }

        int col=matrix[0].length-1;
        int row=0;
        while(col>=0 && row<matrix.length) {

            if (target==matrix[row][col]) return true;
            if (target>matrix[row][col]) row++;
            else if (target<matrix[row][col]) col--;
        }
        return false;
    }

}
