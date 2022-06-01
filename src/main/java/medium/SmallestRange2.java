package medium;

import java.util.Arrays;

public class SmallestRange2 {

    /*
    You are given an integer array nums and an integer k.
    For each index i where 0 <= i < nums.length, change nums[i] to be either nums[i] + k or nums[i] - k.
    The score of nums is the difference between the maximum and minimum elements in nums.
    Return the minimum score of nums after changing the values at each index.
     */

    public static void main(String[] args) {
        System.out.println(smallestRangeII(new int[]{1, 3, 6}, 3));
    }

    public static int smallestRangeII(int[] nums, int k) {
        Arrays.sort(nums);
        int first = nums[0];
        int last = nums[nums.length - 1];
        int ans = last - first;
        for (int i = 0; i < nums.length - 1; i++) {
            int min = Math.min(nums[i + 1] - k, first + k);
            int max = Math.max(nums[i] + k, last - k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
