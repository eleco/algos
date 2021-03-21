package easy;

import utils.ListNode;

import java.util.Stack;

public class ConvertBinaryNumberToInteger {
    /*
    Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
    Return the decimal value of the number in the linked list.
    */

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(1);
        n1.next= n2; n2.next= n3;
        System.out.println(getDecimalValue(n1));
    }

    static int getDecimalValue(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        ListNode tmp = head;
        while (tmp != null) {
            stack.push(tmp.val);
            tmp = tmp.next;
        }

        int count = 0;
        int ptr = 0;

        while (!stack.isEmpty()) {
            count += stack.pop() * Math.pow(2, ptr++);

        }
        return count;

    }
}
