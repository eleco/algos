package easy;

public class CheckIfWordEqualsSumsOfTwoWords {

    /*
    The letter value of a letter is its position in the alphabet starting from 0 (i.e. 'a' -> 0, 'b' -> 1, 'c' -> 2, etc.).

    The numerical value of some string of lowercase English letters s is the concatenation of the letter values of each letter in s, which is then converted into an integer.

    For example, if s = "acb", we concatenate each letter's letter value, resulting in "021". After converting it, we get 21.

    You are given three strings firstWord, secondWord, and targetWord, each consisting of lowercase English letters 'a' through 'j' inclusive.

    Return true if the summation of the numerical values of firstWord and secondWord equals the numerical value of targetWord, or false otherwise.
     */

    public static void main(String[] args) {
        System.out.println(isSumEqual("j","j","bi"));
    }

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        return sum(firstWord) + sum(secondWord)==sum(targetWord);
    }


    static int sum(String s) {
        int sum=0;
        for (int i=0;i<s.length();i++ ) {
            sum= sum*10 +(s.charAt(i)-'a');
        }
        return sum;

    }
}
