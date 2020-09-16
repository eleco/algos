package easy;

import java.util.Arrays;

public class FlippingAnImage {

    /*
    Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.
    To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
     */

    public static void main(String argsp[]) {
        int [][]flipped = flipAndInvertImage(new int[][]{{1,1,0}, {1,0,1}, {0,0,0}});
        for (int i=0;i <flipped.length;i++)
            System.out.println(Arrays.toString(flipped[i]));
    }

    public static int[][] flipAndInvertImage(int[][] A) {

        for (int i = 0; i < A.length; i++) {

            //swapping the elements from the ends, so only half of the array has to be iterated over.
            //If the number of elements is odd, n / 2 won't cover operating on the middle element, so n % 2 is added (== 1 when odd, 0 when even).
            for (int j = 0; j < A[i].length / 2 + A[i].length % 2; j++) {

                int a = A[i][j] == 0 ? 1 : 0;
                int b = A[i][A.length - 1 - j] == 0 ? 1 : 0;
                A[i][j] = b;
                A[i][A.length - 1 - j] = a;
            }
        }
        return A;
    }
}
