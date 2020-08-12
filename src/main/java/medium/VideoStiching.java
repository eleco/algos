package medium;

import java.util.Arrays;

class VideoStitching {

    /*
    You are given a series of video clips from a sporting event that lasted T seconds.  These video clips can be overlapping with each other and have varied lengths.
    Each video clip clips[i] is an interval: it starts at time clips[i][0] and ends at time clips[i][1].  We can cut these clips into segments freely: for example, a clip [0, 7] can be cut into segments [0, 1] + [1, 3] + [3, 7].
    Return the minimum number of clips needed so that we can cut the clips into segments that cover the entire sporting event ([0, T]).  If the task is impossible, return -1.
     */

    public static void main(String args[]) {
        System.out.println(videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 9}, {1, 5}, {5, 9}}, 10));
    }

    public static int videoStitching(int[][] clips, int T) {


        Interval[] intervals = new Interval[clips.length];
        for (int i = 0; i < clips.length; i++) {
            intervals[i] = new Interval(clips[i][0], clips[i][1]);
        }

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start = 0;
        int end = 0;
        int count = 0;
        int i = 0;
        while (end < T) {

            int prevEnd = end;

            while (i < intervals.length && intervals[i].start <= prevEnd) {
                end = Math.max(end, intervals[i].end);
                i++;
            }

            if (start >= end) {
                return -1;
            }
            start = prevEnd;

            count++;

        }
        return count;
    }

    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
