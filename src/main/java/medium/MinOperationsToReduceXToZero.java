package medium;

public class MinOperationsToReduceXToZero {

    /*
    You are given an integer array nums and an integer x.

     In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract
     its value from x. Note that this modifies the array for future operations.

    Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
     */

    public static void main(String[] args) {
        System.out.println(minOperations_dfs(new int[]{3, 2, 20, 1, 1, 3}, 10));
        System.out.println(minOperations_two_pointers(new int[]{3, 2, 20, 1, 1, 3}, 10));
    }

    static int minOperations_two_pointers(int[] nums, int x) {
        //finding min elements to remove so total sum=x
        //is equivalent to
        //finding longest subarray where sum=total sum-x
        //use two pointers to find longest subarray
        int lo = 0;
        int hi = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) sum += nums[i];

        int curSum = 0;
        while (hi < nums.length) {
            curSum += nums[hi];
            while (lo <= hi && curSum > (sum - x)) curSum -= nums[lo++];
            if (curSum == sum - x) {
                max = Math.max(max, hi - lo + 1);
            }
            hi++;
        }
        return (max == Integer.MIN_VALUE ? -1 : nums.length - max);
    }



    // DFS works but too slow
    static int min = Integer.MAX_VALUE;

    static int minOperations_dfs(int[] nums, int x) {
        min = Integer.MAX_VALUE;
        solve_dfs(nums, -1, nums.length, x, 0);
        return (min == Integer.MAX_VALUE ? -1 : min);

    }

    static void solve_dfs(int[] nums, int l, int r, int curSum, int nbOps) {

        if (curSum == 0) {
            min = Math.min(min, nbOps);
            return;
        }

        if (l >= r) {
            return;
        }

        if (l + 1 < r) {
            int take_left = nums[l + 1];
            solve_dfs(nums, l + 1, r, curSum - take_left, nbOps + 1);
        }

        if (r - 1 > l) {
            int take_right = nums[r - 1];
            solve_dfs(nums, l, r - 1, curSum - take_right, nbOps + 1);
        }

    }
}
