package medium;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subset
     */

    public static void main(String argsp[]) {
        System.out.println(subsets(new int[]{4,5,6,7}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();

        //cascase(nums, result);
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, result, 0, nums.length, new ArrayList<Integer>(), i);
        }
        return result;
    }


    public static void dfs(int[] nums, List<List<Integer>> result, int first, int max,
                           List<Integer> l, int size) {

        if (size == l.size()) {
            result.add(new ArrayList(l));
            return;
        }
        for (int i = first; i < max; i++) {
            l.add(nums[i]);
            dfs(nums, result, i + 1, max, l, size);
            l.remove(l.size() - 1);
        }
    }


    public static void cascade(int[] nums, List<List<Integer>> result) {

        result.add(new ArrayList());

        for (int i = 0; i < nums.length; i++) {
            int initialSize = result.size();
            for (int j = 0; j < initialSize; j++) {
                List<Integer> l = new ArrayList(result.get(j));
                l.add(nums[i]);
                result.add(l);
            }
        }
    }
}
