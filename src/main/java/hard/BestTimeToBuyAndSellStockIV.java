package hard;

public class BestTimeToBuyAndSellStockIV {

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{2,4,1}));
    }

    static int mem[][][];

    static int maxProfit(int k, int[] prices) {
        mem = new int[2][prices.length][k + 1];
        return recur(k, prices, 1, 0);
    }

    static int recur(int k, int[] p, int buy, int idx) {

        if (k <= 0 || idx == p.length) {
            return 0;
        }

        if (mem[buy][idx][k] != 0) {
            return mem[buy][idx][k];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-p[idx] + recur(k, p, 0, idx + 1), recur(k, p, 1, idx + 1));
        } else {
            profit = Math.max(p[idx] + recur(k - 1, p, 1, idx + 1), recur(k, p, 0, idx + 1));
        }
        mem[buy][idx][k] = profit;
        return profit;


    }
}
