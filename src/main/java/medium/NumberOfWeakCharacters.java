package medium;

public class NumberOfWeakCharacters {

    /*
    You are playing a game that contains multiple characters,
    and each of the characters has two main properties: attack and defense.
    You are given a 2D integer array properties where properties[i] = [attacki, defensei]
    represents the properties of the ith character in the game.

    A character is said to be weak if any other character has both attack and defense levels
    strictly greater than this character's attack and defense levels.
    More formally, a character i is said to be weak if there exists another character j
    where attackj > attacki and defensej > defensei.

    Return the number of weak characters.
     */

    public static void main(String[] args) {
        System.out.println(numberOfWeakCharacters(new int[][]{{2, 2}, {3, 3}}));
    }

    static int numberOfWeakCharacters(int[][] properties) {

        java.util.Arrays.sort(properties, new java.util.Comparator<>() {
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0]) ? a[1] - b[1] : b[0] - a[0];
            }
        });

        int weaklings = 0;
        int maxDefenseSoFar = properties[0][1];
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < maxDefenseSoFar) {
                weaklings++;
            } else {
                maxDefenseSoFar = properties[i][1];
            }
        }
        return weaklings;
    }
}
