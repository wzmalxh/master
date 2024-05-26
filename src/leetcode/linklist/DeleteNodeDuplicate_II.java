package leetcode.linklist;

public class DeleteNodeDuplicate_II {

      public static class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }


    public static ListNode solution(ListNode head){
        ListNode res = new ListNode(0);
        res.next =head;
        ListNode pre = res;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            //二者不想等，pre往前走，设置为cur
            if(pre.next == cur){
                pre = cur;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return res.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = solution(l1);
        while(res != null){
            System.out.print(res.val+" ");
            res = res.next;
        }

    }
}
