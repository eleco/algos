package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }

    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combies = new ArrayList();
        rec(candidates, target, 0, combies, new ArrayList(), 0);
        return combies;
    }


    static void rec(int[] candidates, int target, int sum, List<List<Integer>> combies, List<Integer> current, int start) {

        if (sum > target) {
            return;
        }

        if (sum == target) {
            combies.add(current);
        }

        for (int i = start; i < candidates.length; i++) {
            List<Integer> newcurrent = new ArrayList();
            newcurrent.addAll(current);
            newcurrent.add(candidates[i]);
            rec(candidates, target, sum + candidates[i], combies, newcurrent, i);
        }
    }
}
