package medium;

import java.util.*;

public class WordLadder {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list.
     */
    public static void main(String args[]) {
        System.out.println(ladderLength("hit", "cog",
                List.of("hot","dot","dog","lot","log","cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> visited = new HashSet<String>();
        Queue<String> q = new LinkedList<String>();

        HashSet setWordList = new HashSet(wordList);
        q.add(beginWord);
        int level=0;
        while(!q.isEmpty()) {

            level++;

            int qsize = q.size();

            for (int j=0;j<qsize;j++) {

                String s = q.poll();
                if (visited.contains(s)) continue;
                if (s.equals(endWord)) {
                    return level;
                }
                visited.add(s);
                setWordList.remove(s);

                for (int i=0;i<s.length();i++) {
                    for (char c ='a';c<='z';c++) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i,c);
                        if (!visited.contains(sb.toString()) && setWordList.contains(sb.toString())) {
                            q.add(sb.toString());
                        }

                    }
                }

            }

        }
        return 0;
    }
}
