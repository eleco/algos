package easy;

public class FirstBadVersion {

    /*
    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

    You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     */

    static int badVersion;


    static boolean isBadVersion(int mid) {
        return mid == badVersion;
    }

    public static void main(String[] args) {
        badVersion = 4;
        System.out.print(firstBadVersion(5));
    }

    public static int firstBadVersion(int n) {
        return bsearch(1, n);
    }


    private static int bsearch(int lo, int hi) {

        int mid = lo + (hi - lo) / 2;

        if (isBadVersion(mid)) {
            if (mid == 0) return 0;

            if (!isBadVersion(mid - 1)) return mid;

            return bsearch(1, mid - 1);
        } else {
            return bsearch(mid + 1, hi);
        }

    }
}

