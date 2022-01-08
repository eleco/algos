package medium;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubSetSum {

    /*
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
     such that the sum of elements in both subsets is equal.
     */

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 2, 3, 4}));
    }

    static boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;

        int target = sum / 2;

        Set<Integer> memo = new HashSet();

        return dfs(0, nums, 0, target, memo);
    }

    static boolean dfs(int curSum, int[] nums, int start, int target, Set<Integer> memo) {
        if (curSum == target) {
            return true;
        }

        for (int i = start; i < nums.length; i++) {
            if (!memo.contains(curSum + nums[i])) {
                boolean ret = dfs(curSum + nums[i], nums, i + 1, target, memo);
                memo.add(curSum + nums[i]);
                if (ret) return true;
            }
        }
        return false;
    }


}
