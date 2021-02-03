package medium;

import java.util.*;

public class PartitionEqualSubSetSum {

    /*
    Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets
     such that the sum of elements in both subsets is equal.
     */

    public static void main(String[] args) {
        System.out.println(canPartition_v1(new int[]{1,2,3,4}));
        System.out.println(canPartition_v2(new int[]{1,2,3,4}));
    }

    public static boolean canPartition_v1(int[] nums) {

        int sum=0;
        for (int i=0;i<nums.length;i++) sum+=nums[i];
        if (sum%2!=0) return false;

        Set<Integer> possibleSums = new HashSet<>(Collections.singletonList(0));
        for (int i=0;i<nums.length;i++) {
            Set<Integer> clonedSums = new HashSet(possibleSums);
            for (Integer s : clonedSums)  possibleSums.add(s+nums[i]);
        }
        return possibleSums.contains(sum/2);
    }


    public static boolean canPartition_v2   (int[] nums) {
        int sum=0;
        for (int num : nums)  sum += num;

        if (sum%2!=0) return false;

        return rec(0,0, sum/2, nums);
    }

    static Map<Key, Boolean> m = new HashMap<Key, Boolean>();

    static boolean rec(int sum, int idx, int target, int [] nums) {

        if (sum==target) return true;

        if (idx>nums.length-1) return false;

        m.put(new Key(sum, idx), false);
        Boolean a = m.get(new Key(sum+nums[idx], idx+1));
        Boolean b = m.get(new Key(sum, idx+1));

        return (
                (a!=null  ? a : rec(sum+nums[idx],idx+1, target, nums))
                        ||
                        (b!=null ? b: rec(sum, idx+1, target, nums))
        );
    }

    static class Key {
        int sum;
        int idx;

        @Override
        public boolean equals(Object o) {
            return ((Key)o).sum == this.sum && ((Key)o).idx == this.idx;
        }

        @Override
        public int hashCode() {
            return sum*idx;
        }

        public Key(int sum, int idx) {
            this.sum= sum;
            this.idx = idx;
        }
    }
}
