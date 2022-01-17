package easy;

import java.util.Arrays;

public class FlipImage {

    public static void main(String[] args) {
        /*
        Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
        To flip an image horizontally means that each row of the image is reversed.
        For example, flipping [1,1,0] horizontally results in [0,1,1].
        To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
        For example, inverting [0,1,1] results in [1,0,0].
       */

        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
    }

    static int[][] flipAndInvertImage(int[][] image) {
        int [][] ret = new int[image.length][image[0].length];
        for (int i=0;i<image.length;i++) {
            for (int j=0;j<image[i].length;j++) {
                ret[i][j]=image[i][image[j].length-j-1];
                if (ret[i][j]==0)  {
                    ret[i][j]=1;
                } else ret[i][j]=0;
            }

        }
        return ret;

    }
}
