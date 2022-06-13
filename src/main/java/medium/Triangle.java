package medium;

import java.util.Arrays;
import java.util.List;

public class Triangle {

    /*
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below.
     More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
     */

    public static void main(String[] args) {
        System.out.println(minimumTotal(List.of(List.of(2), List.of(3,4), List.of(5,6,7), List.of(4,1,8,3))));
    }

    static int [][] mem = new int[201][10001];
    static int minimumTotal(List<List<Integer>> triangle) {
        for (int i=0;i<200;i++)
            Arrays.fill(mem[i],Integer.MAX_VALUE);
        return solve(triangle,0,0);
    }


    static int solve(List<List<Integer>> triangle, int i, int j) {

        if (i>=triangle.size() || j>=triangle.get(i).size()) {
            return 0;
        }

        if (mem[i][j]!=Integer.MAX_VALUE) return mem[i][j];

        int take = solve(triangle, i+1,j+1);
        int nottake = solve(triangle, i+1,j);
        mem[i][j] = Math.min(take,nottake) + triangle.get(i).get(j);
        return mem[i][j];




    }
}
