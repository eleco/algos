package easy;

import java.util.HashSet;
import java.util.Set;

public class JewelAndStones {

    public static void main(String args[]) {
        System.out.println(numJewelsInStones("aA", "abcdAefA"));
    }


    public static int numJewelsInStones(String J, String S) {

        if (J == null || J.equals("") || S == null || S.equals("")) return 0;


        Set<Character> s = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) s.add(J.charAt(i));

        int jewels = 0;

        for (int i = 0; i < S.length(); i++) {
            if (s.contains(S.charAt(i))) jewels++;
        }

        return jewels;
    }
}


