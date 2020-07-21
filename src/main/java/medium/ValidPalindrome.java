package medium;

public class ValidPalindrome {


    /*
     Given a string, return whether or not it forms a palindrome ignoring case and non-alphabetical characters.
     */
    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
    }

    public static boolean isPalindrome(String s) {

        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character a = s.charAt(left);
            if (!Character.isDigit(a) && !Character.isAlphabetic(a)) {
                left++;
                continue;
            }

            Character b = s.charAt(right);
            if (!Character.isDigit(b) && !Character.isAlphabetic(b)) {
                right--;
                continue;
            }
            if (!a.equals(b)) return false;
            left++;
            right--;
        }

        return true;
    }
}
