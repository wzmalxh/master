package leetcode.linklist;

public class DeleteLastNNode {

    class ListNode{
        int val;
        ListNode next;

        public ListNode(int x){
            this.val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        ListNode slow = pre;
        for(int i=0; i< n; i++){
            cur = cur.next;
        }
        while(cur.next != null){
            cur = cur.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pre.next;
    }
}
