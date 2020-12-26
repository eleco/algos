package easy;

import utils.ListNode;

import java.util.Stack;

public class PalindromLinkedList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;

        System.out.println(isPalindrome(n1));
    }


    public static boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<Integer>();

        ListNode cur = head;
        while(cur!=null) {
            s.push(cur.val);
            cur=cur.next;
        }

        cur = head;
        while(!s.isEmpty()) {
            if (s.pop()!=cur.val) return false;
            cur= cur.next;
        }
        return true;

    }
}
