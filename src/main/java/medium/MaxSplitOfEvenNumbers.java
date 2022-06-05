package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxSplitOfEvenNumbers {

    public static void main(String[] args) {
        System.out.println(maximumEvenSplit(24));

    }

    public static List<Long> maximumEvenSplit(long finalSum) {

        if (finalSum % 2 != 0) return Collections.emptyList();

        List<Long> ret = new ArrayList<>();
        long curSum = finalSum;

        //greedy approach
        long cnt = 2L;
        while (cnt <= curSum) {

            curSum -= cnt;
            ret.add(cnt);
            cnt += 2;


        }
        if (curSum > 0) {
            long last = ret.remove(ret.size() - 1);
            ret.add(curSum + last);
        }
        return ret;
    }
}
