package easy;

import java.util.Arrays;

public class TwoSumLessThanK {

    /*
    Given an array A of integers and integer K, return the maximum S such that there exists i < j with A[i] + A[j] = S
     and S < K. If no i, j exist satisfying this equation, return -1.
     */

    public static void main(String[] args) {

        System.out.println(twoSumLessThanK(new int[]{1,-1, 5,6,7,8,3,2},10));
    }

    static int twoSumLessThanK(int [] a, int K) {
        Arrays.sort(a);
        int hi  = a.length-1;
        int lo=0;
        int ans=Integer.MIN_VALUE;
        while (lo<hi) {
            int mid = a[hi] + a[lo];
            if (mid<K) {
                ans =Math.max(ans, mid);
                hi--;
            } else {
                lo++;
            }
        }
        return (ans==Integer.MIN_VALUE?-1:ans);
    }

}
