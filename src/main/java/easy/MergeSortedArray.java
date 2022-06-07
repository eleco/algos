package easy;

import java.util.Arrays;

public class MergeSortedArray {
    /*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
     representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
      and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
     */


    public static void main(String[] args) {
        System.out.println(Arrays.toString(merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = 0;
        int i = m + n - 1;
        int n1 = m - 1;
        int n2 = n - 1;

        while (n1 >= 0 && n2 >= 0) {


            if (nums2[n2] > nums1[n1]) {
                nums1[i--] = nums2[n2--];
            } else {
                nums1[i--] = nums1[n1--];
            }
        }
        while (n2 >= 0) {
            nums1[i--] = nums2[n2--];
        }
        return nums1;
    }

}
