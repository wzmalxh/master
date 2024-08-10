package leetcode.linklist;

public class ReverseFromMToNMyself {

    public static class ListNode{
        private ListNode next;
        private int value;

        public ListNode(int val){
            this.value = val;
        }
    }

    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        ListNode dummy = new ListNode(-2);
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        ListNode start = cur;
        ListNode end = start;
        for (int i = 0; i < n - m ; i++) {
            end = end.next;
        }
        ListNode tmp = end.next;
        end.next = null;
        pre.next = reverseList(cur);
        start.next = tmp;
        if(m == 1){
            return  pre.next;
        }
        //反转链表
        return dummy.next;
    }

    public static ListNode reverseList (ListNode head) {
        // write code here
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next =  l4;
        l4.next = l5;

        ListNode res = reverseBetween(l1,2,4);
        while(res != null){
            System.out.print(res.value+"->");
            res = res.next;
        }

        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(5);
        l6.next = l7;
        ListNode res2 = reverseBetween(l6,1,2);
        while(res2 != null){
            System.out.print(res2.value+"->");
            res2 = res2.next;
        }


    }

}
