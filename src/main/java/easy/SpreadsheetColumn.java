package easy;

public class SpreadsheetColumn {

    /*
    Given a column title as appear in an Excel sheet, return its corresponding column number.
    */

    public static void main(String args[]) {
        System.out.println(titleToNumber("AB"));
    }

    public static int titleToNumber(String s) {

        int r =0;
        int p = 0;
        char[]c = s.toCharArray();
        for (int i=c.length-1; i>=0;i--) {
            int j = c[i]-'A'+1;
            r+=j*Math.pow(26,p++);
        }
        return r;
    }

}
