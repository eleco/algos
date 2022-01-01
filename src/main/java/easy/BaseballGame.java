package easy;

import java.util.Stack;

public class BaseballGame {

    /*
    You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

    At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:

        An integer x - Record a new score of x.
        "+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
        "D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
        "C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.

    Return the sum of all the scores on the record.
     */

    public static void main(String[] args) {
        System.out.println(calcPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    public static int calcPoints(String[] ops) {
        Stack<Integer> stack = new Stack<Integer>();
        for (String o : ops) {

            if (o.equals("C")) {
                stack.pop();
            } else if (o.equals("D")) {
                int i1 = stack.peek();
                stack.push(i1 * 2);

            } else if (o.equals("+")) {
                int i1 = stack.pop();
                int i2 = stack.pop();
                stack.push(i2);
                stack.push(i1);
                stack.push(i1 + i2);

            } else {
                stack.push(Integer.parseInt(o));
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            Integer i = stack.pop();
            total += i;
        }
        return total;
    }

}
