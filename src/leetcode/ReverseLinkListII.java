package leetcode;

public class ReverseLinkListII {
    static class ListNode{
        ListNode next;
        int val;

        public ListNode(int v){
            this.val = v;
        }
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode begin = head;

        for(int i=1; i< left; i++){
            begin = begin.next;
            pre = pre.next;
        }
        ListNode end = begin;
        for(int i=0; i< (right-left); i++){
            end = end.next;
        }
        ListNode tmp = end.next;
        end.next = null;
        pre.next = reverse(begin,end);
        begin.next = tmp;
        return res.next;
    }

    public static ListNode reverse(ListNode head, ListNode end){
        ListNode pre = null;
        ListNode cur = head;
        while(pre != end){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre= cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reverse2(ListNode head, int n){
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode pre = null;
        ListNode cur = head;
        for(int i=0; i< n; i++){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre= cur;
            cur = tmp;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l2.next = null;


        ListNode ll = reverse(l3,l5);
        ListNode l = l5;
        while(ll != null){
            System.out.println(ll.val);
            ll = ll.next;
        }

    }
}
