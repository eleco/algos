package easy;

public class MinValueStepByStepSum {

    /*
    Given an array of integers nums, you start with an initial positive value startValue.
    In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
    Return the minimum positive value of startValue such that the step by step sum is never less than 1.
     */

    public static void main(String [] args) {
        System.out.println(minStartValue(new int[]{-3,2,-3,4,2}));
    }


    public static int minStartValue(int[] nums) {
        int min=Integer.MAX_VALUE;
        int total=0;
        if (nums==null || nums.length==0) return 0;
        for (int i=0;i<nums.length;i++) {
            total+=nums[i];
            min=Math.min(total, min);
        }

        return (min>=0) ? 1: -min+1;
    }
}
