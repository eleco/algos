package easy;

public class StringAddition {

    public static void main(String[] args) {
        System.out.println(addStrings("123", "4"));
    }

    public static String addStrings(String num1, String num2) {


        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {

            int n1 = (i >= 0) ? Integer.valueOf(num1.charAt(i--) - '0') : 0;
            int n2 = (j >= 0) ? Integer.valueOf(num2.charAt(j--) - '0') : 0;
            int s = n1 + n2 + carry;
            carry = s / 10;
            sb.append(s % 10);
        }
        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
