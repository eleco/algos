package easy;

import utils.ListNode;

public class DeleteElement {


    public static void main(String args[]) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(removeElements(n1, 2));
    }

    public static ListNode removeElements(ListNode head, int val) {

        ListNode fakeHead = new ListNode(0, head);

        ListNode prev = fakeHead;
        ListNode curNode = head;

        while (curNode != null) {

            int v = curNode.val;
            if (v == val) {
                prev.next = curNode.next;
                curNode = curNode.next;
            } else {
                prev = curNode;
                curNode = curNode.next;

            }

        }
        return fakeHead.next;

    }



}

