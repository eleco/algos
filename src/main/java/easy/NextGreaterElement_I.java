package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {


    /*
    You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.

    Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
    If it does not exist, return -1 for this number.
     */
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                nextGreaterElement(
                        new int[]{1,3,5,2,4}, new int[]{6,5,4,3,2,1,7})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Stack<Integer> s = new Stack<Integer>();
        for (int i=0;i<nums2.length; i++) {
            while (!s.isEmpty() && nums2[i]>s.peek()) {
                m.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }


        int[] out = new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            out[i] = m.getOrDefault(nums1[i], -1);
        }
        return out;
    }
}
