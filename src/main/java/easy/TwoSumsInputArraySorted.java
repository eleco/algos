package easy;

import java.util.Arrays;

public class TwoSumsInputArraySorted {


    /*
      Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that
      they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
      where 1 <= index1 < index2 <= numbers.length.

      Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

      The tests are generated such that there is exactly one solution. You may not use the same element twice.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1,5,6,7},11)));

    }

    public static int[] twoSum(int[] numbers, int target) {

        int lo=0;
        int hi =  numbers.length-1;

        while(lo<hi) {

            int s = numbers[hi]+numbers[lo];
            if (s==target) return new int[]{lo+1,hi+1};
            if (s<target) lo++;
            if (s>target) hi--;
        }
        return new int[]{};

    }
}
