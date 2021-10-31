package hard;

import java.util.Arrays;

public class FirstMissingPositive {


    public static void main(String[] args) {
        System.out.println(firstMissingPositive_solution1(new int[]{1, 4, 6}));
        System.out.println(firstMissingPositive_solution2(new int[]{1, 4, 6}));
        System.out.println(firstMissingPositive_solution1(new int[]{-1, 4, 6}));
        System.out.println(firstMissingPositive_solution2(new int[]{-1, 4, 6}));
    }

    static int firstMissingPositive_solution1(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        if (nums.length == 1) {
            return (nums[0] < 1) ? 1 : (nums[0] == 1) ? 2 : 1;
        }

        Arrays.sort(nums);
        int pos = 0;

        if (nums[0] > 1) return 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 1 && nums[i] > 1) {
                return 1;
            }

            if (nums[i] > 1 && nums[i - 1] > 0 && nums[i - 1] < nums[i] - 1) {
                return nums[i - 1] + 1;
            }

            if (nums[i] >= 1) {
                pos = nums[i];
            }
        }
        return pos + 1;
    }


    static int firstMissingPositive_solution2(int[] nums) {
        if (nums == null || nums.length == 0) return 1;

        //insight = first missing positive
        //must be between 1.. nums.length because otherwise
        //If there is no missing integer, this means that the array has all number from 1 to n

        //flag cells with negative numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = Integer.MAX_VALUE;
            }
        }

        //flag cells where cell value is positive (-1 to account for zero-based array)
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (v > nums.length) {
                continue;
            }

            v--;
            if (nums[v] > 0) {
                nums[v] = nums[v] * -1;
            }
        }

        //find first cell not flagged, return its index (+1 to account for -1 above)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

}
