package easy;

import utils.ListNode;

public class MergeLinkedList {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(6);
        n4.next = n5;
        n5.next = n6;

        System.out.println(mergeTwoLists(n1, n4));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode fh = new ListNode(0);
        ListNode l = fh;
        while (l1 != null && l2 != null) {

            if (l1.val > l2.val) {
                l.next = l2;
                l2 = l2.next;
                l = l.next;
            } else {
                l.next = l1;
                l1 = l1.next;
                l = l.next;
            }
        }
        while (l1 != null) {
            l.next = l1;
            l1 = l1.next;
            l = l.next;
        }
        while (l2 != null) {
            l.next = l2;
            l2 = l2.next;
            l = l.next;
        }
        return fh.next;

    }
}

