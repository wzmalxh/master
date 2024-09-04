package leetcode.linklist;

public class ReverseFromMToN {

    static class ListNode {
        int x;

        ListNode next;
        public ListNode(int v){
            this.x = v;
        }
    }
    public static ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = head;
        for(int i=0; i< m-1; i++){
            slow = slow.next;
            fast = fast.next;
        }
        //fast是第一个要被反转的元素

        //循环反转 fast到n-m的长度
        ListNode pre = null;
        ListNode cur = fast;
        ListNode tmp = new ListNode(-1);

        for(int i=0; i< n-m+1; i++) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        //1 指向4
        slow.next = pre;
        //2 指向5

        for(int k=0; k < n-m; k++){
            if(pre.next != null) {
                pre = pre.next;
            }
        }
        pre.next = tmp;

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l1.next = l2;
        ListNode res = reverseBetween(l1,1,2);
        while (res != null) {
            System.out.println(res.x);
            res = res.next;
        }
    }
}
