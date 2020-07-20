package easy;

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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur == this ? cur.val : "-->" + cur.val);
                cur = cur.next;
            }
            return sb.toString();
        }


    }

}

