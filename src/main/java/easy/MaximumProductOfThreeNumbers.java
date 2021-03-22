package easy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumProductOfThreeNumbers {

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-1, 2, 3}));
    }

    static int maximumProduct(int[] nums) {

        PriorityQueue<Integer> posPq = new PriorityQueue<>();
        PriorityQueue<Integer> negPq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            posPq.offer(nums[i]);
            if (posPq.size() > 3) {
                posPq.poll();
            }

            if (nums[i] < 0) {

                negPq.offer(nums[i]);
                if (negPq.size() > 2) {
                    negPq.poll();
                }
            }
        }

        int maxPos = Integer.MIN_VALUE;
        int maxMax = Integer.MIN_VALUE;
        while (!posPq.isEmpty()) {
            int i = posPq.poll();

            maxMax = i;
            if (maxPos == Integer.MIN_VALUE) {
                maxPos = i;
            } else {
                maxPos = maxPos * i;
            }
        }

        int maxNeg = (negPq.isEmpty() ? 0 : maxMax);
        while (!negPq.isEmpty()) {
            maxNeg *= negPq.poll();
        }
        return Math.max(maxPos, maxNeg);
    }

}
