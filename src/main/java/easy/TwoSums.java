package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target
     */

    public static void main(String args[]) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer p = m.get(nums[i]);
            if (p != null) {
                return new int[]{p, i};
            }
            m.put(target - nums[i], i);
        }
        return new int[]{};

    }

}


