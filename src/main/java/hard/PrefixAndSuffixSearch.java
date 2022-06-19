package hard;

import java.util.HashMap;
import java.util.Map;

public class PrefixAndSuffixSearch {

    /*
    Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

    Implement the WordFilter class:

    WordFilter(string[] words) Initializes the object with the words in the dictionary.
    f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
    */
    class WordFilter {

        Map<String, Integer> m  = new HashMap<>();
        public WordFilter(String[] words) {
            //idea is to generate all possible prefixes and suffixes
            //then store a map together with the index
            for (int i=0;i<words.length;i++) {

                for (int j=0;j<=words[i].length();j++) {
                    String prefix = words[i].substring(0,j);

                    for (int k=words[i].length();k>=0;k--) {
                        String subfix = words[i].substring(k);
                        String key=prefix+"#"+subfix;
                        m.put(key,i);     //only care about the largest index
                    }

                }
            }
        }

        public int f(String prefix, String suffix) {
                Integer v = m.get(prefix+"#"+suffix);
                return v==null ? -1:v;
        }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
