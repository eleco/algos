package easy;

public class AddOne {

    /*
    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
     */

    public int[] plusOne(int[] digits) {


        int number = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        //case where all digits are 9
        int[] n = new int[digits.length + 1];
        n[0] = 1;
        return n;
    }
}