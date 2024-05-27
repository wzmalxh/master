package leetcode.linklist;

public class DeleteDuplicateDemo {
    class ListNode{
        int val;

        ListNode next;

        public ListNode(int x){
            this.val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy =new ListNode(-1);
        dummy.next = head;
        ListNode cur= dummy;
        if(head == null){
            return head;
        }
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }

        }
        return dummy.next;
    }
}
