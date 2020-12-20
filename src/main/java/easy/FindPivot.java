package easy;

public class FindPivot {


    /*
    Given an array of integers nums, write a method that returns the "pivot" index of this array.
    We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
    If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
     */
    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,3,5,2,2}));
    }

    public static int pivotIndex(int[] nums) {
        for (int i=0;i<nums.length;i++) {


            int left = 0;
            int right = 0;
            for (int j=0;j<i;j++) {
                left+=nums[j];
            }

            for (int k=i+1;k<nums.length;k++) {
                right+=nums[k];
            }
            if (left==right) return i;
        }
        return -1;
    }
}

