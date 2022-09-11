package hard;

import java.util.PriorityQueue;

import static java.util.Arrays.sort;

public class MaximumPerformanceOfATeam {

    /*
    You are given two integers n and k and two integer arrays speed and efficiency both of length n. There are n engineers numbered from 1 to n. speed[i] and efficiency[i] represent the speed and efficiency of the ith engineer respectively.

    Choose at most k different engineers out of the n engineers to form a team with the maximum performance.

    The performance of a team is the sum of their engineers' speeds multiplied by the minimum efficiency among their engineers.

    Return the maximum performance of this team. Since the answer can be a huge number, return it modulo 109 + 7.
     */


    public static void main(String[] args) {
        System.out.println(maxPerformance(6,
                new int[]{2, 10, 3, 1, 5, 8},
                new int[]{5,4,3,9,7,2}, 2));
    }

    static int pow = (int) (Math.pow(10, 9) + 7);

    static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {


        int[][] eng = new int[n][2];
        for (int i = 0; i < n; i++) {
            eng[i][0] = speed[i];
            eng[i][1] = efficiency[i];
        }

        sort(eng, (e1, e2) -> (e2[1] - e1[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long max = 0;
        long teamSpeed = 0;


        for (int i = 0; i < n; i++) {

            pq.add(eng[i][0]);

            if (pq.size() > k) {
                teamSpeed -= pq.poll();
            }
            teamSpeed += eng[i][0];
            max = Math.max(teamSpeed * eng[i][1], max);
        }


        return (int) (max % pow);


    }
}
