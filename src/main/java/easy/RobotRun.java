package easy;

public class RobotRun {

    /*
    There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves,
    judge if this robot ends up at (0, 0) after it completes its moves.

    The move sequence is represented by a string, and the character moves[i] represents its ith move.
    Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.

    */
    public static void main(String args[]) {
        System.out.println(judgeCircle("UDL"));
        System.out.println(judgeCircle("UDLR"));
    }

    public static boolean judgeCircle(String moves) {

        int x = 0;
        int y = 0;

        for (Character c : moves.toCharArray()) {
            if (c == 'U') y--;
            if (c == 'D') y++;
            if (c == 'R') x++;
            if (c == 'L') x--;

        }
        return (x == 0) && (y == 0);


    }
}

