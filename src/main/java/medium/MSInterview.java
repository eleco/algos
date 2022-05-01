package medium;

import java.util.ArrayList;
import java.util.List;

public class MSInterview {

    public static void main(String[] args) {
        /*
        Given an input string of size 2n, consisting of letter's "a" and "b" only, generate all the different permutation. Input string will always be even size and the number of "a" and "b" will be n.
        Eg:
        input: "aabb"
        output: aabb,abab,abba,bbaa,baba,baab ...

        input:"ab"
        output: "ab","ba";
         */

        System.out.println(solution(4));
    }

    private static List<String> solution(int n) {
        ArrayList<String> l = new ArrayList();
        rec(n,l,"",0,0);
        return l;
    }


    private static void rec(int n, ArrayList<String> l, String cur, int a, int b) {

        if (a + b == n) {
            if (a==b) {
                l.add(cur);
            }
            return;
        }

        for (int i=0;i<2;i++) {
            if (i==0) {
                String s = new String(cur);
                s+="a";
                rec(n, l, s, a + 1, b);


            } else {
                String s = new String(cur);
                s+= "b";
                rec(n, l, s, a, b + 1);
            }
        }


    }




}
