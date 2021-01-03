package easy;

public class ShortestWordDistance {

    /*
    Find an efficient algorithm to find the smallest distance
    (measured in number of words) between any two given words in a string.
     */

    public static void main(String[] args) {
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(distance(words, "coding", "practice"));
        System.out.println(distance(words, "makes", "coding"));
    }

    private static int distance(String[] words, String s1, String s2) {
        int l1 = -1;
        int l2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(s1)) {
                l1 = i;
            } else if (words[i].equals(s2)) {
                l2 = i;
            }
            if (l1 >= 0 && l2 >= 0) {
                min = Math.min(min, Math.abs(l1 - l2));
            }
        }
        return min;

    }
}
