package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKClosest {

    /*
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:

        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b

     */
    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1,2,3,4,5},  4,  -1));
    }

    static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> q = new PriorityQueue();


        for (int i=0;i<arr.length;i++) {
            if (k>0) {
                q.offer(arr[i]);
                k--;
            } else if (Math.abs(arr[i]-x)<Math.abs(q.peek()-x)) {
                q.poll();
                q.offer(arr[i]);
            }
        }

        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()) {
            l.add(q.poll());
        }
        return l;
    }
}
