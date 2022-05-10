package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    /*
    Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
    Only numbers 1 through 9 are used.
    Each number is used at most once.

    Return a list of all possible valid combinations.
    The list must not contain the same combination twice, and the combinations may be returned in any order.
     */

    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 10));
    }

    static List<List<Integer>> combinationSum3(int k, int n) {


        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<List<Integer>> ret = new ArrayList<>();
        rec(a, ret, new ArrayList(), 0, k, n);
        return ret;
    }


    static void rec(int[] a, List<List<Integer>> ret, List<Integer> cur, int idx, int k, int n) {

        if (cur.size() == k) {
            int sum = cur.stream().reduce(0, Integer::sum);
            if (sum == n) {
                ret.add(cur);
            }
            return;
        }

        for (int i = idx; i < a.length; i++) {
            List<Integer> ll = new ArrayList(cur);
            ll.add(a[i]);
            rec(a, ret, ll, i + 1, k, n);
        }
    }


}
