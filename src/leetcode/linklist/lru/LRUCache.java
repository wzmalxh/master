package leetcode.linklist.lru;

import java.util.HashMap;

public class LRUCache {
    private int size;

    private int capacity;

    public HashMap<Integer, CacheNode> map = new HashMap<>();

    private CacheNodeList cache;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new CacheNodeList(capacity);
    }

    public int get(int key) {
        if (map.get(key) != null) {
            cache.moveToTail(key, map.get(key).val);
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key));
            //如果存在，移动到最远删除的位置
            cache.moveToTail(key, value);
        } else {
            if (cache.getSize() == capacity) {
                //删除最早访问的节点
                cache.removeFirst();
                CacheNode c = cache.head.next;
                map.remove(c.key);
            }
            map.put(key, map.get(key));
            cache.moveToTail(key,value);
        }
    }
}
