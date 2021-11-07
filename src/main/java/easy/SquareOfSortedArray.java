package easy;

import java.util.Arrays;

public class SquareOfSortedArray {

   /*
   Given an integer array nums sorted in non-decreasing order,
   return an array of the squares of each number sorted in non-decreasing order.
    */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, 1, 3, 5, 10})));
    }


    public static int[] sortedSquares(int[] nums) {

        int hi = nums.length - 1;
        int lo = 0;
        int idx = nums.length - 1;

        int[] result = new int[nums.length];


        while (lo <= hi) {

            if (nums[lo] * nums[lo] > nums[hi] * nums[hi]) {
                result[idx--] = nums[lo] * nums[lo];
                lo++;

            } else {
                result[idx--] = nums[hi] * nums[hi];
                hi--;
            }

        }
        return result;

    }
}
