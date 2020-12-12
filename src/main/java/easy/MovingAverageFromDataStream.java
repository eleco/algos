package easy;

import java.util.ArrayList;
import java.util.List;

public class MovingAverageFromDataStream {

    //Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

    static int windowSize = 3;
    static int [] arr = new int[windowSize];
    static int idx =0;
    static int sum=0;

    public static void main(String args[]) {
        int [] input = new int [] {10,2,5,3,9,7,8};
        List<Integer> result = new ArrayList<Integer>();
        for (int i=0;i<input.length;i++) result.add(movingAverage(input[i]));
        System.out.println(result);
    }

    static int movingAverage(int val) {

        int prev = arr[idx % windowSize];
        sum -= prev;
        sum += val;
        arr[idx%windowSize]=val;
        idx++;
        return sum/windowSize;

    }

}
