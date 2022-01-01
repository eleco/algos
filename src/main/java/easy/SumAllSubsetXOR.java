package easy;

public class SumAllSubsetXOR {
    /*
    The XOR total of an array is defined as the bitwise XOR of all its elements, or 0 if the array is empty.
    For example, the XOR total of the array [2,5,6] is 2 XOR 5 XOR 6 = 1.
    Given an array nums, return the sum of all XOR totals for every subset of nums.
    Note: Subsets with the same elements should be counted multiple times.
    An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b.
     */

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{2, 3}));
    }

    static int subsetXORSum(int[] nums) {
        return backtrack(0, nums, 0, 0);
    }


    static int backtrack(int start, int[] nums, int xor, int sum) {
        sum += xor;
        for (int i = start; i < nums.length; i++) {
            xor ^= nums[i];
            sum = backtrack(i + 1, nums, xor, sum);
            xor ^= nums[i];
        }
        return sum;
    }

}
