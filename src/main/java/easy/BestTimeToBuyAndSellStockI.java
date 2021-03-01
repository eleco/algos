package easy;

public class BestTimeToBuyAndSellStockI {

    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.
    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     */

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 2, 34, 46}));
    }

    static int maxProfit(int[] prices) {

        Integer maxProfit = 0;
        Integer minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];

            }
            if (i > 0) {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;

    }
}

