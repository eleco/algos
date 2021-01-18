package medium;

public class AdditiveNumber {

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("112358"));
    }

    public static boolean isAdditiveNumber(String num) {

        if (num == null || num.equals("")) return false;

        for (int i = 1; i <= num.length() - 2; i++) {
            for (int j = i + 1; j <= num.length() - 1; j++) {
                String sa = num.substring(0, i);
                String sb = num.substring(i, j);
                if (sa.length() > 1 && sa.charAt(0) == '0') continue;
                if (sb.length() > 1 && sb.charAt(0) == '0') continue;

                long a = Long.parseLong(sa);
                long b = Long.parseLong(sb);

                if (helper(a, b, num.substring(j))) return true;

            }
        }
        return false;
    }


    private static boolean helper(long a, long b, String num) {

        if (num.equals("")) return true;
        long sum = a + b;
        String s = ((Long) sum).toString();
        if (num.startsWith(s)) {
            return helper(b, a + b, num.substring(s.length()));
        }
        return false;

    }
}

