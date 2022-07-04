package medium;

public class WiggleSubsequence {

    /*
    A wiggle sequence is a sequence where the differences between successive numbers strictly
    alternate between positive and negative.
    The first difference (if one exists) may be either positive or negative.
    A sequence with one element and a sequence with two non-equal elements are trivially wiggle sequences.

    For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) alternate
    between positive and negative.

    In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences.
    The first is not because its first two differences are positive, and the second is not because
     its last difference is zero.

    A subsequence is obtained by deleting some elements (possibly zero) from the original sequence,
    leaving the remaining elements in their original order.

    Given an integer array nums, return the length of the longest wiggle subsequence of nums.
     */

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,7,4,9,2,5}));
    }

    static int wiggleMaxLength(int[] nums) {

        /*
        intuition/idea: go through the array of nums,
        for each diff which breaks the wiggle sequence, reduce the size of the longest possible sequence.
         */
        int count = nums.length;

        Boolean isPositive=null;
        for (int i=1;i<nums.length;i++) {

            int diff=nums[i]-nums[i-1];
            if (diff==0) count--;
            else if (isPositive==null) {
                isPositive = (diff>0);
            } else {
                if ( (diff>0 && isPositive) || (diff<0 && !isPositive)) {
                    count--;
                } else {
                    isPositive = !isPositive;
                }
            }
        }
        return count;
    }
}
