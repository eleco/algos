package medium;

public class MissingElementInSortedArray {

    /*
    Given a sorted array A of unique numbers,
     find the K-th missing number starting from the leftmost number of the array.
     */

    public static void main(String args[]) {
        System.out.println(missingElement(new int[]{4, 7, 9, 10}, 1));
        System.out.println(missingElement(new int[]{4, 7, 9, 10}, 3));
        System.out.println(missingElement(new int[]{1, 2, 4}, 3));
    }


    public static int missingElement(int[] a, int b) {

        int left = 0;
        int right = a.length - 1;
        int countMissing = a[right] - a[left] - (right - left);
        if (countMissing < b) {
            return a[right] - countMissing + b;
        }
        while (left < right) {

            int mid = (left + right) / 2;
            countMissing = a[mid] - a[0] - (mid);

            if (countMissing >= b) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        countMissing = a[left - 1] - a[0] - (left - 1);
        return a[left - 1] - countMissing + b;
    }

}
