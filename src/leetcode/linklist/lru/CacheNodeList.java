package leetcode.linklist.lru;

public class CacheNodeList {
    private int size;

    public CacheNode head;

    public CacheNode tail;

    public CacheNodeList(int capacity){
        this.size = capacity;
        head = new CacheNode(0,0);
        tail = new CacheNode(0,0);
        head.next =tail;
        tail.pre = head;
    }

    public void removeFirst(){
        if(head.next == null || head.next == tail){
            return;
        }
        CacheNode c = head.next;
        head.next = c.next;
        c.next.pre = head;
        c.pre = null;
        c.next = null;
    }

    public void moveToTail(int key, int val){
        CacheNode c = new CacheNode(key,val);
        CacheNode prev = tail.pre;
        prev.next = c;
        c.next = tail;
        c.pre = prev;
        tail.pre = c;
    }

    public int getSize(){
        return this.size;
    }


}
