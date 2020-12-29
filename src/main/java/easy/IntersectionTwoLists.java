package easy;

import utils.ListNode;

public class IntersectionTwoLists {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(getIntersectionNode(n1, n2));
    }


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {


        if (headA==headB) return headA;

        int lenA = 0;
        int lenB = 0;

        ListNode a = headA;
        ListNode b = headB;

        while(a!=null) {
            a = a.next;
            lenA++;
        }
        while(b!=null) {
            b = b.next;
            lenB++;
        }

        for (int i=lenA;i<lenB;i++) {
            headB = headB.next;
        }
        for (int i=lenB;i<lenA;i++) {
            headA = headA.next;
        }

        while(headA!=headB && headA!=null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;


    }
}
