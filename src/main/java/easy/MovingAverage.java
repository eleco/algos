package easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {


    /*Given a stream of integers and a window size, calculate the moving average
    of all integers in the sliding window.
     */

    public static void main(String args[]) {
        MovingAverage m = new MovingAverage(3);

        System.out.println(m.next(3));
        System.out.println(m.next(5));
        System.out.println(m.next(7));
        System.out.println(m.next(6));

    }

    final Queue<Integer> q = new LinkedList<Integer>();
    final int maxSize;
    double sum;

    /**
     * Initializes a MovingAverage with a
     * capacity of `size`.
     */
    public MovingAverage(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * Adds `val` to the stream of numbers
     * and returns the current average of the numbers.
     */
    public double next(int val) {

        q.add(val);
        sum += val;
        if (q.size() > maxSize) {
            int removed = q.remove();
            sum -= removed;
        }
        return sum / q.size();

    }
}

