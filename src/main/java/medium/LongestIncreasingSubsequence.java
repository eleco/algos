package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {

    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

    A subsequence is a sequence that can be derived from an array by deleting some or no elements
    without changing the order of the remaining elements.
    For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     */

    public static void main(String[] args) {
        System.out.println(lengthOfLIS_binarysearch(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(lengthOfLIS_dfs_and_memo(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    static Map<String, Integer> mem = new HashMap<>();

    static int lengthOfLIS_dfs_and_memo(int[] nums) {
        mem = new HashMap<>();
        return solve(nums, 0, -1001);
    }


    static int solve(int[] nums, int i, int prev) {
        String key = "" + prev + ":" + i;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        if (i == nums.length) {
            return 0;
        }

        int nt = 0, t = 0;
        if (prev < nums[i]) {
            nt = 1 + solve(nums, i + 1, nums[i]);
        }
        t = solve(nums, i + 1, prev);


        int rt = Math.max(t, nt);
        mem.put(key, rt);
        return rt;
    }


    static int lengthOfLIS_binarysearch(int[] nums) {
        List<Integer> l = new ArrayList<>();
        l.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > l.get(l.size() - 1)) {
                l.add(nums[i]);
            } else {
                int insertIdx = binSearch(l, nums[i]);
                l.set(insertIdx, nums[i]);
            }
        }
        return l.size();
    }

    static int binSearch(List<Integer> l, int target) {
        int lo = 0;
        int hi = l.size() - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (l.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }


}
