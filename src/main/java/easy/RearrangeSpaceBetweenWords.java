package easy;

public class RearrangeSpaceBetweenWords {

    /*
    You are given a string text of words that are placed among some number of spaces.
    Each word consists of one or more lowercase English letters and are separated by at least one space.
    It's guaranteed that text contains at least one word.

    Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words
    and that number is maximized. If you cannot redistribute all the spaces equally,
    place the extra spaces at the end, meaning the returned string should be the same length as text.

    Return the string after rearranging the spaces.
     */

    public static void main(String[] args) {
        System.out.println(reorderSpaces("  a  test  string here"));
    }

    public static String reorderSpaces(String text) {
        String[] w = text.trim().split("\\s+");
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') spaces++;
        }

        int d = 0;
        int r = 0;

        if (w.length == 1) r = spaces;
        else {
            d = spaces / (w.length - 1);
            r = spaces % (w.length - 1);
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < w.length; i++) {
            out.append(w[i].trim());
            if (i != w.length - 1) {
                out.append(" ".repeat(d));
            }
        }
        out.append(" ".repeat(r));
        return out.toString();
    }
}

