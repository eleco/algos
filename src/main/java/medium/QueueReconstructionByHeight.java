package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {


    public static void main(String[] args) {
        int [][] ret = reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        for (int [] r : ret) {
            System.out.println(r[0]+ " " + r[1]);
        }
    }

    public static int[][] reconstructQueue(int[][] people) {

        //idea = sort people from tallest to smallest first, then by position low to high
        //insert people in the result list by position
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else return o1[1] - o2[1];

            }
        });


        List<int[]> l = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            l.add(people[i][1], people[i]);
        }

        return l.toArray(new int[0][]);


    }

}
