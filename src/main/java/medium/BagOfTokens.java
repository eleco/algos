package medium;

import java.util.Arrays;

public class BagOfTokens {


    /*
    You have an initial power of power, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith token (0-indexed).

    Your goal is to maximize your total score by potentially playing each token in one of two ways:

    If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
    If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.

    Each token may be played at most once and in any order. You do not have to play all the tokens.

    Return the largest possible score you can achieve after playing any number of tokens.
     */

    public static void main(String[] args) {
        System.out.println(bagOfTokensScore(new int[]{100, 200}, 300));
    }

    static int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        int points = 0;
        int max = 0;
        while (i <= j) {

            if (power >= tokens[i]) {
                power -= tokens[i];
                points += 1;
                max = Math.max(max, points);
                i++;
            } else if (points > 0) {
                power += tokens[j];
                points -= 1;
                j--;
            } else break;

        }
        return max;
    }
}
