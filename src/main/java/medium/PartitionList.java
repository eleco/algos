package medium;

import utils.ListNode;

public class PartitionList {

    public static void main(String[] args) {

        ListNode ln1 = new ListNode(1);
        ListNode ln4 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        ListNode ln21 = new ListNode(2);
        ListNode ln5 = new ListNode(5);
        ListNode ln22 = new ListNode(2);

        ln1.next = ln4;
        ln4.next = ln3;
        ln3.next = ln21;
        ln21.next = ln5;
        ln5.next = ln22;

        System.out.println(partition(ln1, 3));
    }

    static ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        ListNode dummySmall = new ListNode(0);
        ListNode dummyLarge = new ListNode(0);

        ListNode smaller = dummySmall;
        ListNode larger = dummyLarge;

        while (head != null) {

            if (head.val < x) {
                smaller.next = head;
                smaller = head;

            } else {
                larger.next = head;
                larger = head;

            }
            head = head.next;
        }

        larger.next = null;
        smaller.next = dummyLarge.next;
        return dummySmall.next;
    }
}

