package easy;

import java.util.Arrays;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     */
    public static void main(String[] args) {

        System.out.println(missingNumber(new int[]{0, 1, 2, 3, 5}));
        System.out.println(binaryMissingNumber(new int[]{0, 1, 2, 3, 5}));
    }

    private static int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = Arrays.stream(nums).reduce(0, (a, b) -> a + b);
        return expected - actual;
    }


    private static int binaryMissingNumber(int[] nums) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        if (nums[0] != 0) return 0;

        while (lo < hi) {

            mid = (lo + hi) / 2;

            if (nums[mid] > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (lo == nums[lo]) ? lo + 1 : lo;
    }
}
