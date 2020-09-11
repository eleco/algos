package medium;

import java.util.Arrays;

public class KokoEatsBananas {


    public static void main(String args[]) {
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    public static int minEatingSpeed(int[] piles, int H) {

        Arrays.sort(piles);
        int lo = 1;
        int hi = piles[piles.length - 1];

        while (lo < hi) {

            int mid = lo + (hi - lo) / 2;
            if (canEat(piles, H, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }

        }
        return lo;
    }

    private static boolean canEat(int[] piles, int H, int k) {

        int nbHours = 0;
        for (int i = 0; i < piles.length; i++) {
            nbHours += piles[i] / k;
            if (piles[i] % k != 0) nbHours++;
        }

        return nbHours <= H;
    }

}
