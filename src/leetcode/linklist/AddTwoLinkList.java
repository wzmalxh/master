package leetcode.linklist;

public class AddTwoLinkList {
    /**
     * leetcode 链表相加
     */

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode addInList(ListNode head1, ListNode head2) {
        // write code here
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode leftRe = reverse(head1);

        ListNode rightRe = reverse(head2);
        //进位标识
        int carry = 0;
        ListNode newRe = new ListNode(-2);
        ListNode head = newRe;
        while (leftRe != null || rightRe != null || carry > 0) {
            int val1 = leftRe == null ? 0 : leftRe.val;
            int val2 = rightRe == null ? 0 : rightRe.val;
            int value = val1 + val2 + carry;
            carry = 0;
            if (value >= 10) {
                carry = value / 10;
            }
            value = value % 10;
            ListNode tmp = new ListNode(value);
            head.next = tmp;
            head = tmp;
            if (leftRe != null) {
                leftRe = leftRe.next;
            }
            if (rightRe != null) {
                rightRe = rightRe.next;

            }
        }
        return reverse(newRe.next);
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(7);
        head.next.next = new ListNode(3);

        ListNode head2 = new ListNode(3);
        head2.next = new ListNode(7);
        ListNode temp = addInList(head, head2);
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }
}
