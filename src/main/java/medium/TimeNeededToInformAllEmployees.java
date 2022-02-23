package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {

    public static void main(String[] args) {
        System.out.println(
                numOfMinutes(2, new int[]{2, 2, -1, 2, 2,2}, new int[]{0, 0, 1, 0, 0, 0}));
    }

    public static int numOfMinutes(int headID, int[] manager, int[] informTime) {

        Map<Integer, List<Integer>> m = new HashMap<>();
        Map<Integer, Node> mn = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            Node n = new Node();
            n.id = i;

            List<Integer> l = m.get(manager[i]);
            if (l == null) l = new ArrayList();
            l.add(i);
            m.put(manager[i], l);

            mn.put(i, n);
        }


        for (int i = 0; i < manager.length; i++) {
            Node n = mn.get(i);
            List<Node> ll = new ArrayList();
            if (m.get(i) != null) {
                for (int ei : m.get(i)) {
                    ll.add(mn.get(ei));
                }
            }
            n.employees = ll;
        }

        for (int i = 0; i < informTime.length; i++) {
            Node n = mn.get(i);
            n.time = informTime[i];
        }

        return traverse(mn.get(headID), 0);
    }


    static int traverse(Node n, int curMax) {
        if (n == null) return 0;

        Integer max = curMax;
        for (Node e : n.employees) {
            max = Math.max(traverse(e, curMax + n.time), max);
        }
        return max;
    }

    static class Node {
        int id;
        List<Node> employees;
        int time;
    }
}
