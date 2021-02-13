package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     */
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static List<String> generateParenthesis(int n) {
        List<String> l = new ArrayList<String>();
        rec(n, l, "", 0, 0);
        return l;
    }


    static void rec(int n, List<String> collector, String s, int open, int closed) {

        if (s.length() == n * 2) {
            collector.add(s);
            return;
        }

        if (open < n)
            rec(n, collector, s + "(", open + 1, closed);

        if (closed < open)
            rec(n, collector, s + ")", open, closed + 1);

    }
}
