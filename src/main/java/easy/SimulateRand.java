package easy;

import java.util.Random;

public class SimulateRand {
    public static void main(String[] args) {
        System.out.println(rand10());
    }

    public static int rand10() {
        int t = 0;
        do {
            int c = rand7();
            int r = rand7();
            t = (c - 1) * 7 + r;

        } while (t > 40);
        return 1 + t % 10;

    }

    static int rand7() {
        return new Random().nextInt(7) + 1;
    }
}

