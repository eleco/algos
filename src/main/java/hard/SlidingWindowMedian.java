package hard;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    /*
    The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
    So the median is the mean of the two middle values.

    For examples, if arr = [2,3,4], the median is 3.
    For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.

    You are given an integer array nums and an integer k. There is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    Return the median array for each window in the original array. Answers within 10-5 of the actual value will be accepted.
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {

        int moves = nums.length -k+1;

        PriorityQueue<Integer>lo = new PriorityQueue<>(1, Collections.reverseOrder());
        PriorityQueue<Integer> hi= new PriorityQueue<>();

        double[]ret = new double[moves];
        for (int i=0;i<nums.length;i++) {

            int add = nums[i];

            if (lo.isEmpty()) lo.offer(add);

            else if (add>median(lo, hi)) {
                hi.offer(add);
                if (hi.size()>lo.size()+1) {
                    lo.offer(hi.poll());
                }
            } else {
                lo.offer(add);
                if (lo.size()>hi.size()+1) {
                    hi.offer(lo.poll());
                }
            }

            if (i>=k) {
                int removed = nums[i-k];
                if (!lo.remove(removed)) hi.remove(removed);
                if (lo.size()>hi.size()+1) {
                    hi.offer(lo.poll());
                }
                if (hi.size()>lo.size()+1) {
                    lo.offer(hi.poll());
                }
            }

            if (i>=k-1) {
                ret[i-k+1]=median(lo,hi);
            }

            median(lo,hi);

        }

        return ret;

    }

    public static double median( PriorityQueue<Integer>lo,  PriorityQueue<Integer> hi) {
        double med=0;
        if (hi.isEmpty()) med= lo.peek();
        else if (hi.size()==lo.size()) med= ((double)lo.peek()+(double)hi.peek())/2.0;
        else if (hi.size()>lo.size()) med= hi.peek();
        else  med= lo.peek();

        //    System.out.println("lo:" + lo + " hi:" + hi + " med:" + med);
        return med;
    }

}
