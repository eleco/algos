package medium;

public class StringWithoutAAAorBBB {

    /*
    Given two integers a and b, return any string s such that:

    s has length a + b and contains exactly a 'a' letters, and exactly b 'b' letters,
    The substring 'aaa' does not occur in s, and
    The substring 'bbb' does not occur in s.

     */
    public static void main(String[] args) {
        System.out.println(strWithout3a3b(5,12));
    }

    static String strWithout3a3b(int a, int b) {
        //greedily pick A and B to avoid AAA and BBB
        return rec(a, b, new StringBuilder());

    }

    static String rec(int a, int b, StringBuilder sb) {
        if (a + b == 0) {
            return sb.toString();
        } else if (sb.toString().length() >= 2 && sb.toString().substring(sb.length() - 2, sb.length()).contains("aa")) {
            sb.append("b");
            return rec(a, b - 1, sb);

        } else if (sb.toString().length() >= 2 && sb.toString().substring(sb.length() - 2, sb.length()).contains("bb")) {
            sb.append("a");
            return rec(a - 1, b, sb);

        } else if (b > 0 && b > a) {
            sb.append("b");
            return rec(a, b - 1, sb);

        } else {
            sb.append("a");
            return rec(a - 1, b, sb);

        }

    }
}
