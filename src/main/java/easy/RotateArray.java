package easy;

import java.util.Arrays;

public class RotateArray {


    public static void main(String args[]) {
        int[] nums = new int[]{3, 5, 6, 7, 8};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        int[] nums2 = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int newPos = (i + k) % nums.length;
            nums2[newPos] = nums[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            nums[i] = nums2[i];
        }
    }

}
