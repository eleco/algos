package medium;

public class WordSearchV2 {


    public static void main(String args[]) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {

                boolean v = dfs(y, x, board, word, visited, 0);
                if (v) return true;

            }
        }
        return false;
    }

    static boolean dfs(int y, int x, char[][] board, String word, boolean[][] visited, int count) {

        if (count == word.length()) return true;

        if (y < 0 || y > board.length - 1) return false;
        if (x < 0 || x > board[0].length - 1) return false;

        if (visited[y][x]) return false;

        if (word.charAt(count) != board[y][x]) return false;

        visited[y][x] = true;

        if (dfs(y - 1, x, board, word, visited, count + 1) ||
                dfs(y + 1, x, board, word, visited, count + 1) ||
                dfs(y, x - 1, board, word, visited, count + 1) ||
                dfs(y, x + 1, board, word, visited, count + 1)) return true;

        visited[y][x] = false;
        return false;
    }
}
