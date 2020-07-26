package easy;

public class RemoveAdjacentDuplicates {

    /*Given a string s containing only lowercase letters, continuously remove adjacent characters
    that are the same and return the result.
     */

    public static void main(String args[]) {
        System.out.println(removeDuplicates("abccba"));
        System.out.println(removeDuplicates("foobar"));
        System.out.println(removeDuplicates("abccbefggfe"));
    }

    public static String removeDuplicates(String S) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (sb.length() > 0 && S.charAt(i) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);

            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();


    }
}
