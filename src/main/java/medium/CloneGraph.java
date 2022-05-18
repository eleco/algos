package medium;

import java.util.*;

public class CloneGraph {

    /*
    Given a reference of a node in a connected undirected graph.

    Return a deep copy (clone) of the graph.

    Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

    class Node {
        public int val;
        public List<Node> neighbors;
    }
     */

    public GNode cloneGraph(GNode node) {
        if (node == null) return null;

        Queue<GNode> q = new LinkedList();
        Set<GNode> visited = new HashSet<>();
        Map<GNode, GNode> map = new HashMap();
        q.add(node);
        GNode clone = new GNode();
        map.put(node, clone);

        while (!q.isEmpty()) {

            GNode polled = q.poll();

            if (visited.contains(polled)) continue;
            visited.add(polled);
            GNode cloned = map.get(polled);
            cloned.val = polled.val;
            cloned.neighbors = new ArrayList<>();

            for (GNode c : polled.neighbors) {
                GNode e = map.get(c);
                if (e == null) {
                    GNode newClone = new GNode();
                    map.put(c, newClone);
                    cloned.neighbors.add(newClone);
                } else {
                    cloned.neighbors.add(e);
                }
                q.add(c);
            }

        }
        return clone;

    }


}

class GNode {
    public int val;
    public List<GNode> neighbors;

    public GNode() {
        val = 0;
        neighbors = new ArrayList<GNode>();
    }

    public GNode(int _val) {
        val = _val;
        neighbors = new ArrayList<GNode>();
    }

    public GNode(int _val, ArrayList<GNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
