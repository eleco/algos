package easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    /*
    A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
    For example, the below binary watch reads "4:51".
    Given an integer turnedOn which represents the number of LEDs that are currently on, return all possible times the watch could represent. You may return the answer in any order.
    The hour must not contain a leading zero.For example, "01:00" is not valid. It should be "1:00".
    The minute must be consist of two digits and may contain a leading zero.For example, "10:2" is not valid. It should be "10:02".
     */

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
    }

    static int[] nums1 = new int[]{8, 4, 2, 1}, nums2 = new int[]{32, 16, 8, 4, 2, 1};

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> str = new ArrayList();
        rec(turnedOn, 0, 0, 0, str);
        return str;
    }

    static void rec(int turnedOn, int start, int hours, int minutes, List<String> str) {

        if (hours > 11) return;
        if (minutes > 59) return;

        if (turnedOn == 0) {
            str.add(hours + ":" + (minutes < 10 ? ("0" + minutes) : minutes));
            return;
        }

        for (int i = start; i < 10; i++) {
            int prevh = hours;
            int prevm = minutes;
            if (i <= 3) {
                hours = hours + nums1[i];
            } else {
                minutes = minutes + nums2[i - 4];
            }
            rec(turnedOn - 1, i + 1, hours, minutes, str);

            hours = prevh;
            minutes = prevm;
        }
    }
}
