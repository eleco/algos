package easy;

public class SmallestIntegerInSortedArray {

    public static void main(String args[]) {
        System.out.println(smallestArray(new int[]{1, 1, 3, 4, 6, 7, 9}));
        System.out.println(smallestArray(new int[]{1, 1, 1, 1, 1}));
        System.out.println(smallestArray(new int[]{2, 3, 6, 7}));
        System.out.println(smallestArray(new int[]{1, 2, 6, 7, 9}));

    }

    public static int smallestArray(int[] a) {

        int[] prefixSum = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i == 0)
                prefixSum[i] = a[0];
            else
                prefixSum[i] = prefixSum[i - 1] + a[i];
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] > prefixSum[i - 1] + 1) {
                return prefixSum[i - 1] + 1;
            }

        }
        return prefixSum[a.length - 1] + 1;
    }
}