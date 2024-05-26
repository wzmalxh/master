package javatest;

import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode res = reverse(l1);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    static  class ListNode{
        private int val;
        private ListNode next;

        public ListNode(int v){
            this.val= v;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
