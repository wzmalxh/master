package leetcode.linklist;

import java.util.HashMap;

public class LRUCache {

    private int size;

    private int capacity;

    public HashMap<Integer, Cache> map = new HashMap<>();

    private DoubleList cache;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        cache = new DoubleList();

    }

    public int get(int key) {
        if (map.get(key) != null) {
            cache.addRecently(key, map.get(key).value);
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            //如果存在，移动到最远删除的位置
            cache.addRecently(key, value);
        } else {
            if (map.size() == capacity) {
                //删除最早访问的节点
                Cache c = cache.removeFirst();
                //LRU缓存中删除cache对象之后，在map中删除
                map.remove(c.key);
            }
            map.put(key, map.get(key));
            cache.addRecently(key, value);
        }
    }


    class Cache {
        private Cache pre;
        private Cache next;
        public int key;
        public int value;

        public Cache(int k, int v) {
            this.key = k;
            this.value = v;
        }

        public int getValue() {
            return this.value;
        }
    }


    class DoubleList {
        private Cache head;
        private Cache tail;
        private int size;

        public DoubleList() {
            Cache head = new Cache(0, -1);
            Cache tail = new Cache(0, -1);
            head.next = tail;
            tail.pre = head;
            head.pre = null;
            tail.next = null;
            this.size = 0;
        }

        public void remove(Cache x) {
            x.pre.next = x.next;
            x.next.pre = x.pre;
            size--;
        }

        public Cache removeFirst() {
            if (head.next == tail) {
                return null;
            }
            Cache node = head.next;
            head.next = node.next;
            node.next.pre = head;
            node.next = null;
            node.pre = null;
            size--;
            return node;
        }

        private void addRecently(int key, int val) {
            Cache c = new Cache(key, val);
            // 先从链表中删除这个节点
            cache.remove(c);
            // 重新插到队尾
            cache.addRecently(key, c.getValue());
            map.put(key, c);
        }
    }
}


