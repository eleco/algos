import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfNumbers {

    //This question is asked by Google. Given two integer arrays, return their intersection.
    //Note: the intersection is the set of elements that are common to both arrays.

    public static void main(String args[]) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 3, 4}, new int[]{4, 5, 6})));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> dups = new HashSet<Integer>();
        Set<Integer> s = new HashSet<Integer>();
        for (Integer n : nums1) {
            s.add(n);
        }
        for (Integer n : nums2) {
            if (s.contains(n)) dups.add(n);
        }

        int[] r = new int[dups.size()];
        int c = 0;
        for (Integer i : dups) {
            r[c++] = i;
        }
        return r;

    }
}
