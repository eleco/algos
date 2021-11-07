package easy;

import java.util.Arrays;

public class MoveZeroes {

    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.
     */

    public static void main(String[] args) {
        int [] a = new int[]{0, 1, 2, 3, 0, 5, 6, 4, 0};
        moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }


    public static void moveZeroes(int[] nums) {

        int i = 0;
        int x = 0;

        while (i < nums.length) {
            if (nums[i] != 0) {
                if (nums[x] == 0) {
                    nums[x] = nums[i];
                    nums[i] = 0;
                    x++;
                } else {
                    if (nums[x] != 0) {
                        x++;
                    }
                }
            } else if (nums[x] != 0) {
                x++;
            }
            i++;
        }

    }
}
