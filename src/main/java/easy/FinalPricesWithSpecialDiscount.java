package easy;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithSpecialDiscount {


    /**
     * Given the array prices where prices[i] is the price of the ith item in a shop.
     * There is a special discount for items in the shop, if you buy the ith item, then you will receive a discount
     * equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i],
     * otherwise, you will not receive any discount at all.
     */

    public static void main(String args[]) {
        System.out.println(Arrays.toString(finalPrices1(new int[]{8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices2(new int[]{8, 4, 6, 2, 3})));

    }

    public static int[] finalPrices1(int[] prices) {

        int[] ret = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            int discount = 0;
            int minIdx = Integer.MAX_VALUE;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    minIdx = Math.min(j, minIdx);
                    discount = prices[minIdx];
                }
            }
            ret[i] = prices[i] - discount;
        }
        return ret;
    }

    public static int[] finalPrices2(int[] prices) {

        int[] ret = new int[prices.length];

        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < prices.length; i++) {
            ret[i] = prices[i];
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        return ret;

    }
}