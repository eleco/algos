package medium;

public class UniquePaths {

    /*

    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    How many possible unique paths are there?
     */

    public static void main(String[] args) {
        System.out.println(uniquePaths(3,4));
    }

    public static int uniquePaths(int m, int n) {

        int[][]a=new int[m][n];
        for (int j=0;j<m;j++) {
            for (int i=0;i<n;i++) {
                if (j==0 && i==0) a[j][i]=1;
                else if (j==0) {
                    a[j][i] = a[j][i-1];
                }
                else if (i==0) {
                    a[j][i] = a[j-1][i];
                }
                else  a[j][i] = a[j-1][i] + a[j][i-1];

            }
        }
        return a[m-1][n-1];
    }

}
