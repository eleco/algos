package medium;

import java.util.*;


public class NetworkDelayTime {

    public static void main(String[] args) {
        /*
        You are given a network of n nodes, labeled from 1 to n.
        You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi),
        where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel
        from source to target.

        We will send a signal from a given node k.
        Return the time it takes for all the n nodes to receive the signal.
        If it is impossible for all the n nodes to receive the signal, return -1.
         */

        System.out.println(networkDelayTime( new int[][]{{2,1,1},{2,3,1}, {3,4,1}},4, 2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {


        //map node to min time to reach node
        Map<Integer, Integer> minTimeToReachNode = new HashMap<>();

        //map nodeA to nodeB + time A->B
        Map<Integer, List<Pair<Integer>>> graph = new HashMap();
        for (int i=0;i<times.length;i++) {
            List<Pair<Integer>> l = graph.get(times[i][0]);
            if (l==null) l = new ArrayList();
            l.add(new Pair<Integer>(times[i][1], times[i][2]));
            graph.put(times[i][0], l);
        }

        Queue<Integer> q = new LinkedList();
        q.add(k);
        minTimeToReachNode.put(k,0);

        while(!q.isEmpty()) {

            int nodeId = q.poll();
            int minTime = minTimeToReachNode.get(nodeId);
            List<Pair<Integer>> l = graph.get(nodeId);

            if (l==null) continue;
            for (Pair<Integer> p : l) {

                Integer minTimeForChild = minTimeToReachNode.get(p.key);
                if (minTimeForChild!=null) {
                    if (minTime + p.value < minTimeForChild) {
                        minTimeToReachNode.put(p.key, minTime + p.value);
                        q.offer(p.key);
                    }

                } else {
                    minTimeToReachNode.put(p.key, minTime + p.value);
                    q.offer(p.key);
                }

            }
        }
        // we couldn't reach to all of the nodes, to return -1
        if (minTimeToReachNode.size() != n) {
            return -1;
        }


        int maxTime = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e :minTimeToReachNode.entrySet()) {
            maxTime = Math.max(maxTime, e.getValue());

        }
        return maxTime;

    }

    static class Pair<T>{
        T key;
        T value;
        Pair(T k, T v) {
            this.key = k; this.value=v;
        }
    }
}
