package easy;

public class WaterBottles {


    /**
     * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
     * The operation of drinking a full water bottle turns it into an empty bottle.
     * Return the maximum number of water bottles you can drink.
     */

    public static void main(String arg[]) {
        System.out.println(numWaterBottles(9, 3));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {

        int drank = 0;
        while (numBottles > 0) {
            numBottles--;
            drank++;
            if (drank % numExchange == 0) numBottles++;
        }
        return drank;
    }
}
