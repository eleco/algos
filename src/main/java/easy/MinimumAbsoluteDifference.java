package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {

    /*
    Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

    Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

    a, b are from arr
    a < b
    b - a equals to the minimum absolute difference of any two elements in arr
     */

    public static void main(String[] args) {
        System.out.println(minimumAbsDifference(new int[]{3,6,9}));
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {

        if (arr==null) return null;

        List<List<Integer>> ret = new ArrayList();

        Arrays.sort(arr);

        Integer maxdiff = Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++) {
            maxdiff = Math.min(maxdiff, Math.abs(arr[i]-arr[i-1]));
        }

        for (int i=1;i<arr.length;i++) {
            if (Math.abs(arr[i]-arr[i-1])==maxdiff) ret.add(List.of(arr[i-1], arr[i]));
        }

        return ret;
    }

}
