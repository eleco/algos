package easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    /**
     * Given an integer array nums and an integer k, return true
     * if there are two distinct indices i and j in the array such that
     * nums[i] == nums[j] and abs(i - j) <= k.
     */

    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
    }

    static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            Integer v = m.get(nums[i]);

            if (v == null) {
                m.put(nums[i], i);
                continue;
            }

            if (Math.abs(i - v) <= k) {
                return true;
            }
            m.put(nums[i], i);

        }
        return false;
    }
}
