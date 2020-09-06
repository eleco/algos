package medium;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorII {

    /*
    Implement a basic calculator to evaluate a simple expression string.
    The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
    The integer division should truncate toward zero.
     */

    public static void main(String args[]) {
        System.out.println(calculate("2+2*3+5"));
    }

    public static int calculate(String s) {

        int total = 0;

        Queue<Character> queue = new LinkedList<Character>();
        char cs[] = s.toCharArray();

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c != ' ') queue.add(c);
        }
        int prev = 0;
        char op = ' ';

        while (!queue.isEmpty()) {

            int powcount = 0;
            int sum = 0;
            while (!queue.isEmpty() && Character.isDigit(queue.peek())) {
                sum = 10 * sum + Integer.valueOf(queue.poll() - '0');
            }

            if (op != ' ') {
                if (op == '+') {
                    total += prev;
                    prev = sum;
                } else if (op == '-') {
                    total += -prev;
                    prev = sum;
                } else if (op == '*') {
                    prev = prev * sum;
                } else if (op == '/') {
                    prev = prev / sum;
                }
            } else {
                prev = sum;
            }

            if (!queue.isEmpty()) {
                op = queue.poll();
            }

        }

        return total + prev;
    }
}

