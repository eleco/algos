package medium;

public class MinimumMovesToTargetScore {

    public static void main(String[] args) {
        System.out.println(solve(10, 4));
        System.out.println(solve(19, 2));
    }


    static int solve(int target, int maxDoubles) {
        int steps = 0;
        int cur = target;
        int doubles = 0;
        while (cur != 1) {
            while (doubles < maxDoubles && cur % 2 == 0) {
                doubles += 1;
                cur /= 2;
                steps++;
            }
            if (doubles == maxDoubles) {
                return cur + steps - 1;
            } else if (cur != 1) {
                cur--;
                steps++;
            }
        }
        return steps;


    }

}
