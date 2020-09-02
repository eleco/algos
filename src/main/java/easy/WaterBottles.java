package easy;

public class WaterBottles {

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
