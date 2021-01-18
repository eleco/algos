package easy;

import java.util.HashMap;
import java.util.Map;

public class StrobogrammaticNumber {

    /**
     *  Strobogrammatic Number
     * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
     * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
     * For example, the numbers "69", "88", and "818" are all strobogrammatic.
     */
    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("96"));
        System.out.println(isStrobogrammatic("003821"));
        System.out.println(isStrobogrammatic("818"));

    }

    public static boolean isStrobogrammatic (String number) {

        Map<Character, Character> mirror = Map.of('0','0','1','1','8','8','6','9','9','6');

        int hi = number.length()-1;
        int lo = 0;
        while (lo<hi) {
            char clo = number.charAt(lo);
            char chi = number.charAt(hi);
            if (mirror.containsKey(clo) && !mirror.get(clo).equals(chi)) return false;
            hi--; lo++;
        }
        return true;
    }



}
