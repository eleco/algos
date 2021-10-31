package medium;

public class MaximumLengthOfPairChain {

    public static void main(String[] args) {
        System.out.println(findLongestChain(new int[][]{{1,2}, {2,3}, {3,4}}));
    }


    public static int findLongestChain(int[][] pairs) {

        if (pairs==null ) return 0;
        if (pairs.length==1) return 1;


        java.util.Arrays.sort(pairs, (a, b) -> Double.compare(a[1], b[1]));

        int count=0;
        int idx =0;
        int curEnd = Integer.MIN_VALUE;

        while (idx<pairs.length) {
            if (pairs[idx][0]>curEnd)
            {
                count++;
                curEnd = pairs[idx][1];
            }
            idx++;
        }

        return count;

    }
}
