package leetcode.linklist;

public class ReverseLinkListFromMToN {

    public static class ListNode{
        private ListNode next;
        private int value;

        public ListNode(int val){
            this.value = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n){
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode p0 = res;

        for(int s = 1; s< m; s++ ){
             p0 = p0.next;
        }
        ListNode cur = p0.next;
        ListNode pre = null;
        for(int k= 0; k< n - m +1 ; k++){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        // 2指向5
        p0.next.next = cur;
        //1指向4
        p0.next = pre;
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
        ListNode res = reverseBetween(l1,2,4);
        while(res != null){
            System.out.print(res.value+" ");
            res = res.next;
        }

    }
}
