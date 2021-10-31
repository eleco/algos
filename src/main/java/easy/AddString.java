package easy;

public class AddString {


    public static void main(String[] args) {
        System.out.println(addStrings("123", "45"));
    }

    static String addStrings(String num1, String num2) {

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int idx = 0;
        while (idx < num1.length() || idx < num2.length()) {


            int s1 = (idx <= num1.length() - 1) ? num1.charAt(num1.length() - 1 - idx) - '0' : 0;
            int s2 = (idx <= num2.length() - 1) ? num2.charAt(num2.length() - 1 - idx) - '0' : 0;

            int sum = s1 + s2 + carry;
            int r = sum % 10;
            int q = sum / 10;

            sb.append(r);
            carry = q;
            idx++;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

}
