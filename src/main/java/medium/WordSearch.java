package medium;

public class WordSearch {


    public static void main(String args[]) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "SEE"));
    }

    static boolean[][] visited;

    public static boolean exist(char[][] board, String target) {

        visited = new boolean[board.length][board[0].length];


        for (int j = 0; j < board.length; j++) {


            for (int i = 0; i < board[j].length; i++) {
                if (explore(board, i, j, target, "")) {
                    return true;
                }
                visited[j][i] = false;
            }

        }
        return false;
    }


    static boolean explore(char[][] board, int i, int j, String target, String word) {


        if (i < 0 || i >= board[0].length || j < 0 || j >= board.length) {
            return false;
        }


        if (visited[j][i]) {
            return false;
        }

        visited[j][i] = true;

        word += board[j][i];

        if (word.equals(target)) {
            return true;
        }

        if (!target.startsWith(word)) {
            visited[j][i] = false;
            return false;
        }


        if (explore(board, i - 1, j, target, word)
                || explore(board, i + 1, j, target, word)
                || explore(board, i, j + 1, target, word)
                || explore(board, i, j - 1, target, word)
        ) {
            return true;
        }

        visited[j][i] = false;
        return false;

    }
}
