package medium;

public class MaximumLengthRepeatedSubarray {

    /*
    Given two integer arrays nums1 and nums2, return the maximum length of a subarray
     that appears in both arrays.
    */
    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
    }

    static int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int[][]mem = new int[nums1.length+1][nums2.length+1];

        for (int i=nums1.length-1; i>=0; i--) {

            for (int j=nums2.length-1; j>=0;j--) {

                if( nums1[i]==nums2[j]) {
                    mem[i][j]=mem[i+1][j+1]+1;
                    max=Math.max(max, mem[i][j]);
                }
            }
        }
        return max;
    }
}
