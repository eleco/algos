package easy;

import java.util.HashSet;
import java.util.Set;

public class LongestSubarrayConsistingOfUniqueElements {

    /*

    Write a method that takes an array of integers and returns the length of its longest subarray with distinct integers.
    e.g. with [1,2,3,4,2,3] it should return 4.
     */
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1, 2, 3, 4, 2, 3}));
        System.out.println(longestSubarray(new int[]{1, 2, 4, 4, 5, 6, 7, 8, 3, 4, 5, 3, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4}));
    }

    static int longestSubarray(int[] a) {

        int i = 0;
        Set<Integer> set = new HashSet<>();

        int max = 0;
        for (int j = 0; j < a.length; j++) {

            if (set.contains(a[j])) {
                i = j;
                set.clear();
            }
            set.add(a[j]);
            max = Math.max(j - i + 1, max);

        }
        return max;


    }


}
