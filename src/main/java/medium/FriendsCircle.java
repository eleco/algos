package medium;

public class FriendsCircle {

    public static void main(String args[]) {
        System.out.println(findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }

    public static int findCircleNum(int[][] M) {

        int cnt = 0;
        boolean[] visited = new boolean[M[0].length];
        for (int i = 0; i < M.length; i++) {

            if (!visited[i]) {
                cnt++;
                dfs(i, M, visited);
            }
        }
        return cnt;
    }


    private static void dfs(int i, int[][] M, boolean[] visited) {

        if (i < 0 || i >= M.length) {
            return;
        }

        if (visited[i]) return;

        visited[i] = true;

        for (int j = 0; j < M[i].length; j++) {
            if (!visited[j] && M[i][j] == 1) dfs(j, M, visited);

        }
    }
}