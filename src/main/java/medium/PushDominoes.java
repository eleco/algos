package medium;

public class PushDominoes {
    /*
    You are given an string representing the initial conditions of some dominoes. Each element can take one of three values:
    L, meaning the domino has just been pushed to the left,
    R, meaning the domino has just been pushed to the right, or
    ., meaning the domino is standing still.
    Determine the orientation of each tile when the dominoes stop falling.
    Note that if a domino receives a force from the left and right side simultaneously, it will remain upright.
     */

    public static void main(String[] args) {
        System.out.println(pushDominoes("..R...L.L"));
    }

    public static String pushDominoes(String dominoes) {

        char[] cs = dominoes.toCharArray();
        int max = cs.length;
        int[] push = new int[cs.length];

        int i = 0;
        while (i < cs.length) {
            if (cs[i] == 'R') {
                max = cs.length;
                push[i] = -max;
                while (i < cs.length - 1 && cs[i + 1] == '.') {
                    push[++i] -= --max;
                }
            }
            i++;
        }

        i = cs.length - 1;
        while (i >= 0) {
            if (cs[i] == 'L') {
                max = cs.length;
                push[i] += max;
                while (i > 0 && cs[i - 1] == '.') {
                    push[--i] += --max;
                }
            }
            i--;
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < push.length; i++) {
            if (push[i] > 0) sb.append('L');
            if (push[i] < 0) sb.append('R');
            if (push[i] == 0) sb.append('.');

        }
        return sb.toString();
    }
}
