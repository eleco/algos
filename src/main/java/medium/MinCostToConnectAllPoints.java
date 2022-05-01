package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinCostToConnectAllPoints {


    /*
    You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
    The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
    Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
     */
    public static void main(String[] args) {
        System.out.println(minCostConnectPoints(new int[][]{{3,12}, {-2,5}, {-4,1}}));
    }

    public static int minCostConnectPoints(int[][] points) {


        int [][]dist = new int [points.length][points.length];
        for (int i=0;i<points.length;i++) {
            for (int j=0;j<points.length;j++) {
                dist[i][j] = dist(points[i], points[j])   ;
            }
        }


        int[]distToTree = new int[points.length];
        Arrays.fill(distToTree, Integer.MAX_VALUE);

        Set<Integer> intree = new HashSet();
        intree.add(0);
        int node =0;
        int distance=0;

        while(intree.size()!=points.length) {

            intree.add(node);
            int min=Integer.MAX_VALUE;
            int minNode= 0;
            for (int i=0;i<points.length;i++) {
                if (intree.contains(i)) continue;
                distToTree[i] = Math.min(distToTree[i], dist[node][i]);
                if (distToTree[i]<min) {
                    min =distToTree[i];
                    minNode=i;
                }
            }

            if (min!=Integer.MAX_VALUE) {
                distance+=min;
            }

            node=minNode;

        }
        return distance;
    }

    private static int dist(int[]p1, int[]p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }



}
