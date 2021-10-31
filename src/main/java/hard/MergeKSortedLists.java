package hard;

import utils.ListNode;

public class MergeKSortedLists {

    /*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
    Merge all the linked-lists into one sorted linked-list and return it.
     */
    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(2);
        n11.next = n12;

        ListNode n21 = new ListNode(3);
        ListNode n22 = new ListNode(7);
        n21.next = n22;

        ListNode n31 = new ListNode(5);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        System.out.println(mergeKLists(new ListNode[]{n11, n21, n31}));
    }


    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;

        ListNode res = lists[0];

        for (int i = 1; i < lists.length; i++) {
            res = merge2lists(res, lists[i]);
        }
        return res;

    }

    static ListNode merge2lists(ListNode l1, ListNode l2) {

        ListNode res = new ListNode(0);
        ListNode head = res;

        while (l1 != null || l2 != null) {
            if ((l1 != null) && (l2 == null || l1.val < l2.val)) {
                res.next = l1;
                l1 = l1.next;
            } else  {
                res.next = l2;
                l2 = l2.next;
            }
            res = res.next;
        }
        return head.next;

    }
}
