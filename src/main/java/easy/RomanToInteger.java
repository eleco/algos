package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /*
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */

    public static void main(String args[]) {
        System.out.println(romanToInt("CXXXIV"));
    }

    public static int romanToInt(String s) {

            if (s==null  || s.length()==0) return 0;
            Map<String, Integer> m = new HashMap<String, Integer>();
            m.put("I",1);
            m.put("V",5);
            m.put("X",10);
            m.put("L",50);
            m.put("C", 100);
            m.put("D", 500);
            m.put("M", 1000);
            m.put("IV", 4);
            m.put("IX", 9);
            m.put("XL", 40);
            m.put("XC", 90);
            m.put("CD", 400);
            m.put("CM", 900);

            int c = 0;
            for (int i=0;i<s.length();i++) {

                Integer r = null;
                if (i<s.length()-1) {
                    r =m.get(s.substring(i,i+2));
                }
                if (r==null) {
                    r =m.get(s.substring(i,i+1));
                } else {
                    i++;
                }
                c+=r;
            }
            return c;
        }
}
