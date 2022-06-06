package easy;

import utils.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionTwoLists {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        System.out.println(getIntersectionNode1(n1, n2));
        System.out.println(getIntersectionNode2(n1, n2));
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        Set<ListNode> n = new HashSet<>();
        while(headA!=null) {
            n.add(headA);
            headA= headA.next;
        }

        while(headB!=null) {
            if (n.contains(headB)) return headB;
            headB= headB.next;
        }
        return null;

    }

    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {


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
