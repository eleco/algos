package easy;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementinSize2NArray {

    /*
    In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.

    Return the element repeated N times.
     */
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1, 2, 3, 3}));
    }

    static int repeatedNTimes(int[] A) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) return A[i];
            set.add(A[i]);
        }
        return 0;
    }

}
