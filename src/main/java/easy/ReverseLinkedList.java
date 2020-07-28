package easy;

import utils.ListNode;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(reverseListIterative(n1));

        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n4.next = n5;
        n5.next = n6;
        System.out.println(reverseListRecursive(n4));

    }

    public static ListNode reverseListIterative(ListNode head) {

        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {

            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;

        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        return recurse(head, null);
    }

    static ListNode recurse(ListNode cur, ListNode prev) {

        if (cur == null) {
            return prev;
        }

        ListNode next = cur.next;
        cur.next = prev;
        return recurse(next, cur);
    }

}
