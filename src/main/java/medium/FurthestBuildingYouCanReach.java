package medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {

    /*
    You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.

    You start your journey from building 0 and move to the next building by possibly using bricks or ladders.

    While moving from building i to building i+1 (0-indexed),

    If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
    If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.

    Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
     */


    public static void main(String[] args) {
        System.out.println(furthestBuilding_priorityQueue(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));
        System.out.println(furthestBuilding_dfs(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1));

    }

    static int furthestBuilding_dfs(int[] heights, int bricks, int ladders) {
        int res = dfs(heights, bricks, ladders, 0);
        return res;
    }

    static int dfs(int[] heights, int bricks, int ladders, int idx) {
        //at each index/building consider picking up bricks or ladder
        //and select best case
        if (idx == heights.length - 1) {
            return idx;
        }
        int curh = heights[idx];
        int curn = heights[idx + 1];
        if (curn <= curh) {
            return dfs(heights, bricks, ladders, idx + 1);
        } else {

            int res_ladder = -1;
            if (ladders > 0) {
                res_ladder = dfs(heights, bricks, ladders - 1, idx + 1);
            }
            int res_bricks = -1;
            if (bricks >= (curn - curh)) {
                res_bricks = dfs(heights, bricks - curn + curh, ladders, idx + 1);
            }


            int res = Math.max(res_ladder, res_bricks);
            return Math.max(idx, res);
        }
    }


    static int furthestBuilding_priorityQueue(int[] heights, int bricks, int ladders) {
        //at each building push distance between buiding into in queue, and assume bricks are used to fill the gap
        //if ever we run out of bricks, then swap largest distance for a ladder
        int i = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (i = 0; i < heights.length - 1; i++) {
            int curh = heights[i];
            int curn = heights[i + 1];
            if (curn > curh) {
                pq.offer(curn - curh);
                bricks -= curn - curh;

                if (bricks < 0) {
                    if (ladders > 0) {
                        Integer biggestDistance = pq.poll();
                        bricks += biggestDistance;
                        ladders -= 1;
                    } else break;
                }
            }
        }
        return i;
    }
}
