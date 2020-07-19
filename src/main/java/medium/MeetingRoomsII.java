package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

    //Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
    // find the minimum number of conference rooms required.


    public static void main(String args[]) {
        System.out.println(rooms(new int[][]{{1, 3}, {2, 4}, {2, 4}, {9, 10}, {9, 10}, {20, 30}, {40, 50}, {60, 80}}));
    }

    public static int rooms(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparing((int[] interval) -> interval[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                count++;
                pq.offer(interval[1]);
            } else {
                if (interval[0] > pq.peek()) {
                    pq.poll();
                } else {
                    count++;
                }
                pq.offer(interval[1]);
            }
        }
        return count;
    }

}
