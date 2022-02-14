package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class FindMedianDataStrea {

    /**
     * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
     * <p>
     * For example, for arr = [2,3,4], the median is 3.
     * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
     * <p>
     * Implement the MedianFinder class:
     * <p>
     * MedianFinder() initializes the MedianFinder object.
     * void addNum(int num) adds the integer num from the data stream to the data structure.
     * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
     */

    static class MedianFinder_Insertion_WithBinarySearch {

        List<Integer> ll = new ArrayList();

        public void addNum(int num) {
            int insertionPt = binarySearch(ll, num);
            ll.add(insertionPt, num);
        }

        public double findMedian() {
            int mid = ll.size() / 2;
            if (ll.size() % 2 == 0) {
                return (ll.get(mid) + ll.get(mid - 1)) / 2.0;
            } else {
                return (double) ll.get(mid);
            }
        }


        private int binarySearch(List<Integer> l, int num) {

            int hi = l.size() - 1;
            int lo = 0;
            while (lo <= hi) {


                int mid = (lo + hi) / 2;
                int m = ll.get(mid);
                if (num <= m) {
                    hi = mid - 1;
                } else lo = mid + 1;
            }
            return lo;
        }
    }


    //at worst 2 heap insertions O(2 log n) + 2 peek instructions O (2n) --> O(log n)
    static class MedianFinder_PriorityQueue {

        /**
         * initialize your data structure here.
         */

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        public MedianFinder_PriorityQueue() {

        }

        public void addNum(int num) {
            double curmed = findMedian();
            if (num <= curmed) {
                max.offer(num);
                if (max.size() > min.size() + 1) {
                    min.offer(max.poll());
                }
            } else {
                min.offer(num);
                if (min.size() > max.size() + 1) {
                    max.offer(min.poll());
                }
            }
        }

        public double findMedian() {
            if (min.isEmpty() && max.isEmpty()) {
                return 0.0;
            }
            if (min.isEmpty()) return max.peek();
            if (max.isEmpty()) return min.peek();

            if (min.size() == max.size()) {
                return (min.peek() + max.peek()) / 2.0;
            }
            return (min.size() > max.size()) ? min.peek() : max.peek();


        }
    }


}
