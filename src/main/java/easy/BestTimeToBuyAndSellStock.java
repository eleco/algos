package easy;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 4, 5, 3, 5}));
    }

    public static int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int maxDiff = 0;
        for (int i = 0; i < prices.length; i++) {
            int p = prices[i];
            min = Math.min(p, min);
            maxDiff = Math.max(maxDiff, p - min);
        }
        return maxDiff;
    }
}
