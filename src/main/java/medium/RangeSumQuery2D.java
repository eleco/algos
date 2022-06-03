package medium;

public class RangeSumQuery2D {

 /*
    Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

    Implement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
  */


    class NumMatrix {

        /**
         * Your NumMatrix object will be instantiated and called as such:
         * NumMatrix obj = new NumMatrix(matrix);
         * int param_1 = obj.sumRegion(row1,col1,row2,col2);
         */

        int[][] mem;

        public NumMatrix(int[][] matrix) {

            mem = new int[matrix.length][matrix[0].length];

            for (int i = 0; i < matrix.length; i++) {
                mem[i][0] = matrix[i][0];
                for (int j = 1; j < matrix[0].length; j++) {
                    mem[i][j] = matrix[i][j] + mem[i][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {

            int sum = 0;
            for (int i = row1; i <= row2; i++) {
                if (col1 > 0)
                    sum += mem[i][col2] - mem[i][col1 - 1];
                else
                    sum += mem[i][col2];
            }
            return sum;

        }
    }
}
