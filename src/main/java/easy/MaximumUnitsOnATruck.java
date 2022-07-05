package easy;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnitsOnATruck {

    public static void main(String args[]) {
        /*
        You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes,
        where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:

        numberOfBoxes is the number of boxes of type i.
        numberOfUnitsPerBox is the number of units in each box of the type i.

        You are also given an integer truckSize, which is the maximum number of boxes that can be put
        on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.

        Return the maximum total number of units that can be put on the truck.
         */
        System.out.println(maximumUnits(new int[][]{{5,10},{2,5},{4,7},{3,9}},10));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {

        Arrays.sort(boxTypes, (o1, o2) -> o2[1]-o1[1]);

        int units=0;
        for (int[] boxType : boxTypes) {
            int maxBoxes = Math.min(boxType[0], truckSize);
            truckSize -= maxBoxes;
            units += maxBoxes * boxType[1];
        }
        return units;
    }

}
