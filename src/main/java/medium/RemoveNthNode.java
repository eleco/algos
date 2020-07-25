package medium;

import utils.ListNode;

public class RemoveNthNode {

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(removeNthFromEnd(n1, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fakeHead = new ListNode(0, head);
        ListNode fast = fakeHead;
        ListNode slow = fakeHead;

        int i=0;
        while(i<n & fast!=null) {
            fast = fast.next;
            i++;
        }

        while(fast.next!=null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next  = slow.next.next;


        return fakeHead.next;
    }
}
