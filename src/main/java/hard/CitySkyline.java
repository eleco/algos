package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CitySkyline {

    /*
    A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Given the locations and heights of all the buildings, return the skyline formed by these buildings collectively.

    The geometric information of each building is given in the array buildings where buildings[i] = [lefti, righti, heighti]:

    lefti is the x coordinate of the left edge of the ith building.
    righti is the x coordinate of the right edge of the ith building.
    heighti is the height of the ith building.

    You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.

    The skyline should be represented as a list of "key points" sorted by their x-coordinat
    e in the form [[x1,y1],[x2,y2],...]. Each key point is the left endpoint of some horizontal segment
    in the skyline except the last point in the list, which always has a y-coordinate 0 and is
    used to mark the skyline's termination where the rightmost building ends.
    Any ground between the leftmost and rightmost buildings should be part of the skyline's contour.
     */

    public static void main(String[] args) {
        System.out.println(getSkyline(new int[][]{{0,2,3},{2,5,3}}));
    }


    static List<List<Integer>> getSkyline(int[][] buildings) {

        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());

        List<List<Integer>> ret = new ArrayList<>();

        //height at start and end points, mark start as negative to differentiate
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]});
            height.add(new int[]{b[1], b[2]});
        }

        //sort heights by start, or end if start points are equals
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });

        int prev = 0;
        q.add(0);

        //go through the heights,
        for (int[] h : height) {

            //if start add the height, if end remove the height
            if (h[1] < 0) {
                q.offer(-h[1]);
            } else {
                q.remove(h[1]);
            }
            int cur = q.peek();

            //if cur height different than previous add data point
            if (prev != cur) {
                List<Integer> l = new ArrayList<>();
                l.add(h[0]);
                l.add(cur);
                prev = cur;
                ret.add(l);
            }
        }
        return ret;
    }

}
