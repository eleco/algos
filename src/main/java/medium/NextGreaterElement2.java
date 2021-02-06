package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement2 {

    /*
    Given a circular array (the next element of the last element is the first element of the array),
    print the Next Greater Number for every element.
    The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
     which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
     */

    public static void main(String[] args) {

        System.out.println(Arrays.toString(
                nextGreaterElements(new int[]{100, 1, 11, 1, 120, 111, 123, 1, -1, -100})));
    }


    static public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < nums.length * 2; i++) {
            int idx = i % nums.length;
            while (!s.isEmpty() && nums[idx] > nums[s.peek()]) {
                m.put(s.pop(), nums[idx]);
            }
            s.push(idx);
        }

        int[] out = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            out[i] = m.getOrDefault(i, -1);
        }
        return out;

    }
}
