package medium;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PlatesBetweenCandles {

    /*
    There is a long table with a line of plates and candles arranged on top of it.
    You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.
    You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive).
    For each query, you need to find the number of plates between candles that are in the substring.
    A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.

    For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
    Return an integer array answer where answer[i] is the answer to the ith query.
    */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("***|**|*****|**||**|*",
                new int[][]{{1, 17}, {4, 5}, {14, 17}, {5, 11}, {15, 16}})));
    }

    static int[] platesBetweenCandles(String s, int[][] queries) {

        //array of plates indices
        Set<Integer> plates = new LinkedHashSet();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                plates.add(i);
            }
        }


        int[] a = new int[plates.size()];
        int i = 0;
        for (Integer ix : plates) {
            a[i++] = ix;
        }


        int ret[] = new int[queries.length];
        int idxRet = 0;

        for (int[] q : queries) {
            int q0 = q[0];
            int q1 = q[1];
            int start = 0;
            int end = 0;

            //bisect left - find the plate to the right of q0
            int min = 0;
            int max = a.length;
            int mid = 0;
            while (min < max) {
                mid = (min + max) / 2;
                if (a[mid] < q0) {
                    min = mid + 1;
                } else max = mid;
            }
            start = min;


            //bisect right - find the plate to the left of q1
            min = 0;
            max = a.length;
            while (min < max) {
                mid = (min + max) / 2;
                if (a[mid] > q1) {
                    max = mid;
                } else min = mid + 1;
            }
            end = min - 1;

            //num candles = num elements(plates and candles) between start and end, minus num of plates
            ret[idxRet++] = (start > end) ? 0 : a[end] - a[start] - (end - start);
        }

        return ret;

    }
}
