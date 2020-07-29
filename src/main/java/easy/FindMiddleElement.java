package easy;

import utils.ListNode;

public class FindMiddleElement {

    public static void main(String args[]) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(middleNode(n1));
    }

    public static ListNode middleNode(ListNode head) {
        int counter=0;
        ListNode cur = head;
        while(cur!=null) {
            cur=cur.next;
            counter++;
        }

        cur=head;
        for (int i=0;i<counter/2;i++) {
            cur=cur.next;
        }
        return cur;

    }
}
