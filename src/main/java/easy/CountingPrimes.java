package easy;

public class CountingPrimes {

    public static void main(String args[]) {

        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        int count = 0;

        boolean[] notPrimes = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!notPrimes[i]) {
                for (int j = 2; i * j < n; j++) {
                    notPrimes[i * j] = true;
                }
                count++;
            }

        }
        return count;
    }

}
