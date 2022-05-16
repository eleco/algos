package easy;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInArray {

    public static void main(String[] args) {
        System.out.println(mostFrequent(new int[]{1, 100, 200, 1, 100}, 1));
    }

    public static int mostFrequent(int[] nums, int key) {

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {

            if (nums[i - 1] == key) {
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int target = 0;
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            if (e.getValue() > max) {
                target = e.getKey();
                max = e.getValue();
            }
        }
        return target;


    }
}
