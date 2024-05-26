package leetcode.linklist;

public class ReverseListNodeKGroup {
    public static class ListNode{
        private ListNode next;
        private int value;
        public ListNode(int val){
            this.value = val;
        }
    }


    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if(end == null){
                break;
            }else{
                ListNode start = pre.next;
                ListNode tmp = end.next;
                end.next = null;
                pre.next = reverse(start);
                start.next = tmp;
                pre = start;
                end = pre;
            }

        }
        return dummy.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
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
        l3.next = l4;
        l4.next = l5;
        ListNode res = reverseKGroup(l1,2);
        while(res != null){
            System.out.print(res.value+" ");
            res = res.next;
        }
    }

}
