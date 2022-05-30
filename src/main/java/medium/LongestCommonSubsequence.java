package medium;

public class LongestCommonSubsequence {
    static int mem[][];

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        mem = new int[text1.length()][text2.length()];
        System.out.println(rec(text1, text2, 0, 0));
    }


    private static int rec(String t1, String t2, int i1, int i2) {

        if (i1 >= t1.length() || i2 >= t2.length()) return 0;

        if (mem[i1][i2] != 0) return mem[i1][i2];

        int ret;
        if (t1.charAt(i1) == t2.charAt(i2)) {
            ret = rec(t1, t2, i1 + 1, i2 + 1) + 1;
        } else {

            int a = rec(t1, t2, i1 + 1, i2);
            int b = rec(t1, t2, i1, i2 + 1);
            ret = Math.max(a, b);
        }
        mem[i1][i2] = ret;
        return ret;
    }
}
