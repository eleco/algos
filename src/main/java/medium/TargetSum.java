package medium;

public class TargetSum {

    /*
    You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
    Find out how many ways to assign symbols to make sum of integers equal to target S.
     */

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1,1,1,1,1},3));
    }


    static int findTargetSumWays(int[] nums, int S) {
        return sub(nums,S,0, 0);
    }

    static int sub (int [] nums, int target,  int sum, int pos) {

        if (pos==nums.length) {
            return (sum==target) ? 1:0;
        }

        int count=0;
        count+=sub (nums,  target,  sum+nums[pos] ,pos+1);
        count+=sub (nums,  target,  sum-nums[pos] ,pos+1);

        return count;

    }
}