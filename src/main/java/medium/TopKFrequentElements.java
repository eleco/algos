package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {


    public static void main(String []args){
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4, 4, 4, 4}, 2)));
    }
    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> m = new HashMap<Integer, Integer>();

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a, b)->(b.getValue()-a.getValue()));
        pq.addAll(m.entrySet());

        int c = 0;
        int [] ret = new int[k];
        while(!pq.isEmpty() && k>0) {
            Map.Entry<Integer,Integer> ee = pq.poll();
            ret[c++]= ee.getKey();
            k--;
        }
        return ret;
    }

}

