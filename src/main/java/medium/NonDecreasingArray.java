package medium;

public class NonDecreasingArray {

    /*
     * Given an array nums with n integers, your task is to check if it could become
     * non-decreasing by modifying at most one element.
     *
     * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based)
     * such that (0 <= i <= n - 2).
     *
     */

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
    }

    public static boolean checkPossibility(int[] nums) {

        /*
        idea = go through the list of numbers
        - if there is a 'kink' in the list, try and fix it
        - fix can only be applied once
        */
        boolean decreasing = false;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                if (decreasing) {
                    return false;
                } else {
                    decreasing = true;
                    if (i > 0 && nums[i - 1] > nums[i + 1]) {
                        nums[i + 1] = nums[i];
                    }
                }
            }
        }
        return true;
    }
}
