public class SpotTheDifference {


    public static void main(String[] args) {
        System.out.println(findTheDifference1("tide","tride"));
        System.out.println(findTheDifference2("tide","tride"));

    }

    public static char findTheDifference2(String s, String t) {
        int scode = 0;
        int tcode=0;
        for (int i=0;i<s.length();i++) {
            scode+=(int)s.charAt(i);
        }
        for (int i=0;i<t.length();i++) {
            tcode+=(int)t.charAt(i);
        }
        return (char) (tcode-scode);
    }

        public static char findTheDifference1(String s, String t) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            a[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            a[c - 'a']--;
            if (a[c - 'a'] < 0) return c;
        }

        return ' ';
    }
}
