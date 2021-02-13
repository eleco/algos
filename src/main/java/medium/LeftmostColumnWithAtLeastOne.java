package medium;

public class LeftmostColumnWithAtLeastOne {

    /**
     * (This problem is an interactive problem.)
     *
     * A row-sorted binary matrix means that all elements are 0 or 1 and each row of the matrix is sorted in non-decreasing order.
     *
     * Given a row-sorted binary matrix binaryMatrix, return the index (0-indexed) of the leftmost column with a 1 in it.
     * If such an index does not exist, return -1
     */

    /**
     * BinaryMatrix required on classpath
     */

    /*public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        Integer minMin = Integer.MAX_VALUE;
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);
        for (int i=0;i<rows;i++) {
            int min = binarySearch(i, cols, binaryMatrix);
            if (min>=0) minMin = Math.min(minMin, min);
        }
        return minMin<Integer.MAX_VALUE ? minMin:-1;
    }



    public int binarySearch(int row, int cols, BinaryMatrix bm) {


        int hi = cols-1;
        int lo=0;
        while(lo<=hi) {

            int mid =(lo+hi)/2;
            int v = bm.get(row, mid);
            if (v==0) {
                lo=mid+1;
            } else {

                if (mid==0) return 0;
                int prev = bm.get(row, mid-1);
                if (prev==0) return mid;
                hi = mid-1;
            }
        }
        return -1;


    }*/
}
