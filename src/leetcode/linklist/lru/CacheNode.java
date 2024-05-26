package leetcode.linklist.lru;

public class CacheNode {
    CacheNode pre;
    CacheNode next;

    int key;

    int val;

    public CacheNode(int k,int v){
        this.key = k;
        this.val = v;
    }
}
