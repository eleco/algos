package medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {


    /*

    Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest
     of the intervals non-overlapping.
     */
    public static void main(String args[]) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}, {2,3}, {3,4}, {1,3}}));
    }

    public static int eraseOverlapIntervals(int[][] arr) {
        if (arr == null || arr.length == 0) return 0;

        Interval[] intervals = new Interval[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intervals[i] = new Interval(arr[i][0], arr[i][1]);
        }

        Arrays.sort(intervals, new myComparator());

        int count = 0;
        Interval currentInterval = intervals[0];
        int end = currentInterval.b;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].a >= end) {
                end = intervals[i].b;
                count++;
            }
        }
        return arr.length - count - 1;
    }


    static class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.b - b.b;
        }
    }

    static class Interval {
        int a;
        int b;

        public Interval(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
