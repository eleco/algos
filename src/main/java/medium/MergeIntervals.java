package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    /*
    Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
    and return an array of the non-overlapping intervals that cover all the intervals in the input.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                merge(new int[][]{{1, 5}, {3, 8}, {15, 18}})));
    }

    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int open = intervals[0][0];
        int close = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            int nextOpen = intervals[i][0];
            int nextClose = intervals[i][1];

            if (nextOpen > close) {
                list.add(new int[]{open, close});
                open = nextOpen;
                close = nextClose;
            } else {
                close = Math.max(close, nextClose);
            }
        }
        list.add(new int[]{open, close});

        int[][] ret = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            ret[j][0] = list.get(j)[0];
            ret[j][1] = list.get(j)[1];
        }
        //return list.toArray(new int[list.size()][]);
        return ret;

    }
}



