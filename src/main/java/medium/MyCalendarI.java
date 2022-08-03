package medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {

    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(10, 20));
        System.out.println(calendar.book(15, 25));
        System.out.println(calendar.book(20, 30));
        System.out.println();
    }

    static class MyCalendar {

        List<int[]> bookings;

        public MyCalendar() {
            bookings = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] b : bookings) {

                if (start < b[1] && end > b[0]) {
                    return false;
                }
            }

            bookings.add(new int[]{start, end});
            return true;
        }
    }
}
