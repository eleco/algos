package medium;

import java.util.Arrays;
import java.util.Comparator;

public class ArrowsToBurstBallons {
    /*
    There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
    An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
     */

    public static void main(String argsp[]) {
        System.out.println(findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }

    public static int findMinArrowShots(int[][] points) {


        if (points == null || points.length == 0) return 0;

        Interval[] intervals = new Interval[points.length];
        for (int i = 0; i < points.length; i++) {
            intervals[i] = new Interval(points[i][0], points[i][1]);
        }


        Arrays.sort(intervals, new MyComparator());

        int arrows = 1;
        int curEnd = intervals[0].b;
        for (int i = 1; i < intervals.length; i++) {
            System.out.println("a:" + intervals[i].a + " b:" + intervals[i].b);

            if (intervals[i].a > curEnd) {
                arrows++;
                curEnd = intervals[i].b;
            } else {
                curEnd = Math.min(intervals[i].b, curEnd);
            }


        }
        return arrows;

    }


    static class MyComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {

            return (a.a - b.a);
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

