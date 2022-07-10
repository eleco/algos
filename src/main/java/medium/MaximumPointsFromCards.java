package medium;

import java.util.stream.IntStream;

public class MaximumPointsFromCards {

    /*
    There are several cards arranged in a row, and each card has an associated number of points.
    The points are given in the integer array cardPoints.

    In one step, you can take one card from the beginning or from the end of the row.
    You have to take exactly k cards.

    Your score is the sum of the points of the cards you have taken.

    Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     */

    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{1,2,3,4,5,6,1},3));
    }

   static int maxScore(int[] cardPoints, int k) {
        //first calculate all the points possible when picking only cards from the right
        //then unpick one card from the right, pick a new card from the left and recalculate
       //to see if the max points score can be improved
        int left=0;
        int right = cardPoints.length-k;

        int sum = IntStream.range(right, right+k).map(i -> cardPoints[i]).sum();
        int best = sum;

        while(k-->0) {
            sum+= -cardPoints[right++] + cardPoints[left++];
            best = Math.max(best, sum) ;

        }
        return best;
    }

}
