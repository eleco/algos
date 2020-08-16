package easy;

import java.util.Arrays;

public class SumZero {

    /*
    Given an integer n, return any array containing n unique integers such that they add up to 0.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(3)));
    }


    public static int[] sumZero(int n) {
        int[]ret = new int[n];
        for (int i=0;i<n/2;i++) {
            ret[i] = n-i;
            ret[n-i-1] = -n+i;
        }
        return ret;
    }
}
