package medium;

public class DeleteOperationForTwoStrings {

    /*
    Given two strings word1 and word2, return the minimum number of steps required to make word1 and word2 the same.

    In one step, you can delete exactly one character in either string.
     */

    public static void main(String[] args) {
        System.out.println(minDistance("sea","eat"));
    }

    static int[][] mem;

    static int minDistance(String word1, String word2) {
        mem = new int[501][501];
        return solve(word1, word2, 0, 0);
    }


    static int solve(String w1, String w2, int i1, int i2) {

        if (i1 > w1.length() || i2 > w2.length()) {
            return 0;
        }

        if (i1 == w1.length() && i2 == w2.length()) {
            return 0;
        }

        if (i1 == w1.length()) {
            return w2.length() - i2;
        }

        if (i2 == w2.length()) {
            return w1.length() - i1;
        }

        if (mem[i1][i2] != 0) {
            return mem[i1][i2];
        }

        if (w1.charAt(i1) == w2.charAt(i2)) {
            return solve(w1, w2, i1 + 1, i2 + 1);

        } else {

            int take1 = solve(w1, w2, i1 + 1, i2);
            int take2 = solve(w1, w2, i1, i2 + 1);
            int ret = 1 + Math.min(take1, take2);
            mem[i1][i2] = ret;
            return ret;
        }
    }
}
