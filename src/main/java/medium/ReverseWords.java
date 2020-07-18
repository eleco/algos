package medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {


    public static void main(String arg[]) {
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        if (s==null || s.length()==0) return "";
        String[] ss = s.trim().split(" ");
        List<String> words = new ArrayList<String>();
        for (int i=ss.length-1;i>=0;i--) {
            if (ss[i].equals("") ||  ss[i].equals(" ")) {
                continue;
            }
            words.add(ss[i]);

        }
        return(String.join(" ", words.toArray(new String[0])));
    }
}

