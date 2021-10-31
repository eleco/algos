package easy;

public class FindSmallestLetterGreaterThanTarget {

    /*
    Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
    find the smallest element in the list that is larger than the given target.
    Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

     */

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c','f','z'},'d'));
    }

    static char nextGreatestLetter(char[] letters, char target) {

        int lo=0;
        int hi = letters.length;
        int mid=0;
        while (lo<hi) {


            mid = (lo+hi)/2;
            int cmid = letters[mid];
            if (cmid<=target) {
                lo=mid+1;
            } else {
                hi=mid;
            }
        }
        if (lo>=letters.length) return letters[0];
        return letters[lo];

    }

}
