package medium;

import utils.ListNode;

public class ReverseLinkedlist2 {

    /*
    Given the head of a singly linked list and two integers left and right where left <= right,
    reverse the nodes of the list from position left to position right, and return the reversed list.
     */

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(3);
        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(5);
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = ln5;

        System.out.println(reverseBetween(ln1, 2, 4));
    }

    static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preReverse = dummy;
        for (int i = 0; i < left - 1; i++) {
            preReverse = preReverse.next;
        }
        ListNode leftNode = preReverse.next;


        ListNode pre = preReverse;
        ListNode current = leftNode;
        ListNode next = leftNode.next;

        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        preReverse.next = pre;
        leftNode.next = current;

        return dummy.next;

    }
}
