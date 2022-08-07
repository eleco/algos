package medium;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarI {

    /*
    You are implementing a program to use as your calendar. We can add a new event if adding
    the event will not cause a double booking.

    A double booking happens when two events have some non-empty intersection
    (i.e., some moment is common to both events.).

    The event can be represented as a pair of integers start and end that represents
     a booking on the half-open interval [start, end),
     the range of real numbers x such that start <= x < end.

    Implement the MyCalendar class:
        MyCalendar() Initializes the calendar object.
        boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

     */


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
