package medium;

import java.util.Arrays;

public class SortColors {
    /*
    Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     */

    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 1, 0, 0, 0, 0, 1, 2, 1};
        sortColors(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sortColors(int[] nums) {

        if (nums.length == 0) return;
        if (nums.length == 1) return;

        int hi = nums.length - 1;
        int lo = 0;
        for (int i = 0; i < nums.length; i++) {


            int k = nums[i];
            if (k == 0) {
                while (lo < nums.length && nums[lo] == 0) lo++;
                if (i > lo) {
                    swap(i, lo, nums);
                    lo++;
                }
            } else if (k == 2) {
                while (hi >= 0 && nums[hi] == 2) hi--;
                if (i < hi) {
                    swap(i, hi, nums);
                    hi--;
                    i--;
                }
            }
        }

    }

    public static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }
}

