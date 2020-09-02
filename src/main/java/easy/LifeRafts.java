package easy;

import java.util.Arrays;

public class LifeRafts {


    public static void main(String args[]) {
        System.out.println(numRescueBoats(new int[]{1, 3, 5, 2}, 3));
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int l = 0;
        int h = people.length - 1;

        while (l < h) {

            if (people[h] + people[l] > limit) {
                h--;
                boats++;
            } else {
                h--;
                l++;
                boats++;
            }
            if (l == h) boats++;

        }
        return boats;
    }
}
