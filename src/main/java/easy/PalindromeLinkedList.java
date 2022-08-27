package easy;

import utils.ListNode;

import java.util.Stack;

public class PalindromeLinkedList {

    /*
    Given the head of a singly linked list, return true if it is a palindrome.

     */
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome_recursive(n1));
        System.out.println(isPalindrome_withStack(n1));
    }

    static boolean isPalindrome_withStack(ListNode head) {

        //1. iterate on the list and all nodes to a stack
        //2. iterate again and check each node == node popped from stack
        if (head == null) return true;
        Stack<Integer> stack = new Stack<>();
        ListNode tail = head;
        int size = 0;
        while (tail != null) {
            size++;
            stack.push(tail.val);
            tail = tail.next;
        }
        int pos = 0;
        while (pos < size / 2) {
            if (stack.pop() != head.val) return false;
            pos++;
            head = head.next;
        }
        return true;
    }

    static boolean isPalindrome_recursive(ListNode head) {

        //1. iterate on list with fast and slow
        //1a. build a reverse list whilst iterating
        //1b. once done slow node = middle of list

        //2, iterate until slow node reach end of list check
        //slow node ==rev node
        if (head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmpslow = slow.next;

            slow.next = prev;
            prev = slow;
            slow = tmpslow;

        }
        if (fast != null) { // if it is odd,
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (prev.val != slow.val) return false;
            prev = prev.next;
            slow = slow.next;

        }

        return slow == null && prev == null;
    }

}
