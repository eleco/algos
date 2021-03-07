package easy;

public class RepeatedSubStringPattern {

    /*
    Given a string s, check if it can be constructed by taking a substring of it and appending multiple
    copies of the substring together.
     */
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabc"));
    }

    static boolean repeatedSubstringPattern(String s) {

        if (s == null) return false;

        if (s.length() == 1) return false;

        for (int j = 0; j < s.length() - 1; j++) {

            String temp = "";
            String added = s.substring(0, j + 1);
            while (temp.length() <= s.length()) {
                if (temp.equals(s)) return true;
                temp += added;
            }
        }
        return false;
    }

}
