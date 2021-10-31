package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String args[]) {
        /*
        Given an integer numRows, return the first numRows of Pascal's triangle.
        In Pascal's triangle, each number is the sum of the two numbers directly above i
         */

        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> r = new ArrayList<>();
        if (numRows == 0) return r;

        r.add(List.of(1));
        if (numRows == 1) return r;

        r.add(List.of(1, 1));
        if (numRows == 2) return r;

        for (int i = 2; i < numRows; i++) {

            List<Integer> l = new ArrayList<>();
            List<Integer> p = r.get(i - 1);
            l.add(p.get(0));
            for (int j = 0; j < p.size() - 1; j++) {
                l.add(p.get(j) + p.get(j + 1));
            }
            l.add(p.get(p.size() - 1));
            r.add(l);
        }
        return r;

    }
}

