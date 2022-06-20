package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionSystem {

    /*
    You are given an array of strings products and a string searchWord.

    Design a system that suggests at most three product names from products after each character of searchWord is typed.
     Suggested products should have common prefix with searchWord.
     If there are more than three products with a common prefix return the three lexicographically minimums products.

    Return a list of lists of the suggested products after each character of searchWord is typed.
     */

    public static void main(String[] args) {
        System.out.println(suggestedProducts_bruteforce(
                new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));

        System.out.println(suggestedProducts_binarysearch(
                new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"}, "mouse"));
    }

    static List<List<String>> suggestedProducts_bruteforce(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>> ret = new ArrayList<>();

        String curWord = "";
        for (int i = 0; i < searchWord.length(); i++) {
            Character c = searchWord.charAt(i);
            List<String> l = new ArrayList<>();
            curWord += String.valueOf(c);
            for (String w : products) {
                if (w.startsWith(curWord)) {
                    if (l.size() < 3) l.add(w);
                }
            }
            ret.add(l);
        }
        return ret;
    }

    static List<List<String>> suggestedProducts_binarysearch(String[] products, String searchWord) {

        Arrays.sort(products);
        List<List<String>> ret = new ArrayList<>();

        String curWord = "";
        for (int i = 0; i < searchWord.length(); i++) {
            Character c = searchWord.charAt(i);
            List<String> l = new ArrayList<>();
            curWord += String.valueOf(c);


            int pos = binSearch(products, curWord);
            for (int j = 0; j < 3; j++) {
                if ((j + pos) < products.length && products[j + pos].startsWith(curWord)) l.add(products[j + pos]);
            }

            if (!l.isEmpty())
                ret.add(l);
        }
        return ret;
    }

    static int binSearch(String[] products, String searchWord) {

        int lo = 0;
        int hi = products.length - 1;
        while (lo < hi) {

            int mid = (hi + lo) / 2;
            if (products[mid].compareTo(searchWord) == 0) {
                return mid;
            } else if (products[mid].compareTo(searchWord) > 0) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

}
