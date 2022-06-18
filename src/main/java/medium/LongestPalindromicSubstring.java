package medium;

public class LongestPalindromicSubstring {

    /*
    Given a string s, return the longest palindromic substring in s.
     */
    public static void main(String[] args) {

        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome2("babad"));

    }


    //Brute force o n*n*n
    /*public String longestPalindrome(String s) {

        int max=0;
       String maxS ="";

        for (int i=0;i<s.length();i++) {

            for (int j=i;j<s.length();j++) {
                String ss = s.substring(i,j+1);

                if (isPal(ss))  {
                    if (ss.length()>max) {
                        max=ss.length();
                        maxS=ss;
                    }
                }
            }

        }
        return maxS;
    }

    private static boolean isPal(String t) {
        if (t==null) return false;
        for (int i=0;i<t.length();i++) {
            if (t.charAt(i)!=t.charAt(t.length()-i-1)) return false;
        }
        return true;
    }*/


    //Expand around center
    public static String longestPalindrome(String s) {

        int max = 0;
        String maxS = "";

        for (int i = 0; i < s.length(); i++) {

            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i + 1);


            if (s1.length() > max) {
                max = s1.length();
                maxS = s1;
            }
            if (s2.length() > max) {
                max = s2.length();
                maxS = s2;
            }
        }
        return maxS;
    }


    private static String expand(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            if (i == j) sb.append(s.charAt(i));
            else {
                sb.append(s.charAt(j));
                sb.insert(0, s.charAt(i));
            }
            i--;
            j++;

        }
        return sb.toString();

    }


    //alternative solution
    //first catch all identical characters e.g case of 'aaaa'
    //then expand from left and right centering on the current character
    static String longestPalindrome2(String s) {

        int max = 0;
        String maxS = "";

        for (int i = 0; i < s.length(); i++) {

            String cur = String.valueOf(s.charAt(i));
            int left = i;
            int right = i;
            while (right <= s.length() - 1) {
                if (cur.length() > max) {
                    max = cur.length();
                    maxS = cur;
                }
                if (right + 1 <= s.length() - 1 && s.charAt(right) == s.charAt(right + 1)) {
                    right++;
                    cur = cur + s.charAt(right);
                } else break;
            }

            while (left >= 0 && right <= s.length() - 1) {
                if (cur.length() > max) {
                    max = cur.length();
                    maxS = cur;
                }

                if (right + 1 <= s.length() - 1 && left - 1 >= 0 && s.charAt(right + 1) == s.charAt(left - 1)) {
                    right++;
                    left--;
                    cur = s.charAt(left) + cur;
                    cur = cur + s.charAt(right);
                } else break;
            }
        }
        return maxS;
    }


    static boolean isPal(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;


    }
}

