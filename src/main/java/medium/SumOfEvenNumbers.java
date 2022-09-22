package medium;

import java.util.Arrays;

public class SumOfEvenNumbers {


    /*
    You are given an integer array nums and an array queries where queries[i] = [vali, indexi].

    For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of
     the even values of nums.

    Return an integer array answer where answer[i] is the answer to the ith query.

     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumEvenAfterQueries(new int[]{1,2,3,4},
                new int[][]{{1,0},{-3,1},{-4,0},{2,3}})));
    }


    static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {

        int sum = 0;
        for (int a : nums) {
            sum += (a % 2 == 0 ? a : 0);
        }
        int[] ret = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int idx = queries[i][1];
            boolean evenBefore = nums[idx] % 2 == 0;
            int numsBefore = nums[idx];
            nums[idx] += queries[i][0];
            boolean evenAfter = nums[idx] % 2 == 0;

            if (evenBefore && evenAfter) {
                sum += nums[idx] - numsBefore;
            } else if (evenBefore && !evenAfter) {
                sum -= numsBefore;
            } else if (evenAfter) {
                sum += nums[idx];
            }
            ret[i] = sum;

        }
        return ret;

    }
}

