package medium;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

    static int findKthLargest(int[] nums, int k) {
        //throw the numbers into a priority queue ordered by default from small to large
        //and trim the queue to keep the distance between head of q <--> tail of q == k
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.offer(i);
            if (pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
