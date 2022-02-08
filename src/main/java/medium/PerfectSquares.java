package medium;


import java.util.*;

class PerfectSquares {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
    }

    static int numSquares(int n) {

        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        Set<Integer> visites = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        boolean found = false;
        int steps = 0;
        while (!q.isEmpty() && !found) {
            steps++;
            int nbneighbours = q.size();

            for (int i = 0; i < nbneighbours; i++) {
                Integer tmp = q.remove();
                if (visites.contains(tmp)) continue;
                visites.add(tmp);
                for (int j = 0; j < squares.size(); j++) {
                    Integer sq = squares.get(j);
                    if (tmp - sq == 0) {
                        found = true;
                        break;
                    } else if (tmp - sq < 0) {
                        continue;
                    } else if (tmp - sq > 0) {
                        q.add(tmp - sq);
                    }

                }
            }
        }

        return steps;
    }
}