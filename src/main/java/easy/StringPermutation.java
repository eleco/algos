package easy;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {


    public static void main(String args[]) {
        System.out.println(letterCasePermutation("abcd"));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList();
        for (int i = 0; i < S.length(); i++) {
            dfs(result, S, String.valueOf(S.charAt(i)), S.length());

        }
        return result;
    }

    private static void dfs(List<String> result, String S, String tmp, int sizeTarget) {

        if (tmp.length() == sizeTarget) {
            result.add(tmp);
        } else {

            for (int i = 0; i < S.length(); i++) {
                if (tmp.indexOf(S.charAt(i)) < 0) {
                    dfs(result, S, tmp + S.charAt(i), sizeTarget);
                }
            }

        }

    }
}

