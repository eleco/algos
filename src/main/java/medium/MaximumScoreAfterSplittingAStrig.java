package medium;

public class MaximumScoreAfterSplittingAStrig {

    public static void main(String[] args) {
        System.out.println(maxScore("100001"));
    }

    static int maxScore(String s) {

        int[] zeroes = new int[s.length()];
        int[] ones = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {

            if (i > 0) {
                ones[i] = ones[i - 1];
                zeroes[i] = zeroes[i - 1];
            }

            if (s.charAt(i) == '1') ones[i]++;
            if (s.charAt(i) == '0') zeroes[i]++;
        }

        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int numZeroes = zeroes[i];
            int numOnes = ones[s.length() - 1] - ones[i];
            max = Math.max(max, numZeroes + numOnes);

        }
        return max;
    }

}
