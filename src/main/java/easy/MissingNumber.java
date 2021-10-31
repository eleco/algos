package easy;

import java.util.Arrays;

public class MissingNumber {

    /*
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
     */
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,2,3,5}));
    }

    private static int missingNumber(int [] nums) {
        int n = nums.length;
        int expected = n * (n+1)/2;
        int actual = Arrays.stream(nums).reduce(0, (a, b)-> a+b);
        return expected-actual;
    }
 }
