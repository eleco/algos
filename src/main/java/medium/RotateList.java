package medium;

import utils.ListNode;

public class RotateList {

    /**
     * Given the head of a linked list, rotate the list to the right by k places.
     */


    static ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;

        //count the number of nodes
        int count = 0;
        ListNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        count++;
        ListNode tail = tmp;

        //find the point in the list where rotation occurs
        int rotatePt = k % count;

        //find the node that will become the new tail
        tmp = head;
        for (int i = 0; i < count - rotatePt - 1; i++) {
            tmp = tmp.next;
        }
        ListNode newtail = tmp;

        //the new head will be the next node after the new tail
        ListNode newhead = (tmp.next == null ? head : tmp.next);


        tail.next = head;
        newtail.next = null;
        return newhead;

    }
}

