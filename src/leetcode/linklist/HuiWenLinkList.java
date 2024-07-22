package leetcode.linklist;

public class HuiWenLinkList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int v){
            this.val = v;
        }
    }

    public ListNode reverseHead(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre =cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode deepCopy(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = new ListNode(head.val);
        newHead.next = deepCopy(head.next);
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode tmp = deepCopy(head);
        ListNode reverseHead = reverseHead(tmp);
        while(head != null && reverseHead != null){
            if(head.val == reverseHead.val){
                head = head.next;
                reverseHead = reverseHead.next;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HuiWenLinkList huiWenLinkList = new HuiWenLinkList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = null;
        boolean b= huiWenLinkList.isPalindrome(l1);
        System.out.println(b);
    }
}
