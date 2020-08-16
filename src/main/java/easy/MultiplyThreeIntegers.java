package easy;

public class MultiplyThreeIntegers {

    /*
    Given a list of integers, return the largest product that can be made by multiplying any three integers.
     */
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-10, -10, 5, 2}));
    }

    public static int maximumProduct(int[] nums) {

        int max1, max2, max3;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        int min1, min2;
        min1 = min2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        if (min2 < Integer.MAX_VALUE) {
            return Math.max(max1 * max2 * max3, max1 * min2 * min1);
        } else {
            return max1 * max2 * max3;
        }

    }
}
