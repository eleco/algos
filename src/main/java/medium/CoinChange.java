package medium;

import java.util.*;

public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,3,5},11));
    }


    public static int coinChange(int[] coins, int amount) {

        Set<Integer> visited = new HashSet<Integer>();
        Queue<Node> q = new LinkedList<>();

        int level = 0;
        q.add(new Node(0));

        while (!q.isEmpty()) {
            List<Node> amountsAtThisLevel = new LinkedList();
            while (!q.isEmpty()) amountsAtThisLevel.add(q.poll());

            for (Node node : amountsAtThisLevel) {
                if (node.amount == amount) {
                    Node track = node;
                    do {
                        System.out.println(track.amount - track.ancestor.amount);
                        track = track.ancestor;
                    }while (track!=null);

                    return level;
                }
                if (visited.contains(node.amount)) continue;
                visited.add(node.amount);

                for (int coin : coins) {
                    int newAmount = node.amount + coin;
                    if (newAmount > 0 && newAmount <= amount) {
                        Node newNode = new Node(newAmount);
                        newNode.ancestor = node;
                        q.add(newNode);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}


class Node
{
    int amount;
    Node ancestor;
    public Node (int amt) {
        this.amount = amt;
    }
}