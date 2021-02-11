package medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {


    /*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.
     */
    public static void main(String[] args) {
        int[][] ret = insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[i].length; j++) System.out.print(ret[i][j]);
            System.out.println("");
        }
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> newIntervals = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {

            if (newInterval != null && newInterval[1] < intervals[i][0]) {
                newIntervals.add(newInterval);
                newInterval = null;
                newIntervals.add(intervals[i]);
            } else if (newInterval != null && newInterval[0] > intervals[i][1]) {
                newIntervals.add(intervals[i]);
            } else if (newInterval != null && (newInterval[0] >= intervals[i][0] || newInterval[1] <= intervals[i][1])) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else if (newInterval == null) {
                newIntervals.add(intervals[i]);
            }
        }
        if (newInterval != null) {
            newIntervals.add(newInterval);
        }

        return newIntervals.toArray(new int[newIntervals.size()][2]);

    }
}
