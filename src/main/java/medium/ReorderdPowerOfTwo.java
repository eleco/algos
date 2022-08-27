package medium;

import java.util.Arrays;

public class ReorderdPowerOfTwo {

    /*
    You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

    Return true if and only if we can do this so that the resulting number is a power of two.
     */

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
    }

   static boolean reorderedPowerOf2(int n) {
        String s1 = String.valueOf(n);
        char[] c1 = s1.toCharArray();
        Arrays.sort(c1);
        String s11= new String(c1);

        for (int i=0;i<31;i++) {

            String s2 = String.valueOf((int)Math.pow(2,i));

            char [] c2 = s2.toCharArray();

            Arrays.sort(c2);
            String s21 = new String(c2);
            if (s21.equals(s11)) return true;
        }
        return false;
    }

}
