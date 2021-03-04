package easy;

import java.util.ArrayList;
import java.util.List;

public class Intersection3SortedArrays {

    public static void main(String[] args) {
        System.out.println(arraysIntersection(new int[]{1, 2, 3}, new int[]{3, 4, 5}, new int[]{3, 6, 7}));
    }

    static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ret = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                ret.add(arr1[i]);
                i++;
                j++;
                k++;
            } else {
                if (arr1[i] < arr2[j] && arr1[i] <= arr3[k]) {
                    i++;
                } else if (arr2[j] < arr3[k] && arr2[j] <= arr1[i]) {
                    j++;
                } else {
                    k++;
                }
            }

        }
        return ret;
    }

}
