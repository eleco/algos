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

    static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> subsets =new ArrayList();
        backtrack(nums, subsets, new ArrayList(),0);
        return subsets;
    }



    static void backtrack (int [] nums, List<List<Integer>> subsets , List<Integer> currSubset, int start) {

        subsets.add(currSubset);

        for (int i=start;i<nums.length;i++) {
            currSubset.add(nums[i]);
            List<Integer> copy = new ArrayList(currSubset);
            backtrack(nums, subsets, copy, ++start);
            currSubset.remove(currSubset.size()-1);
        }
    }
}
