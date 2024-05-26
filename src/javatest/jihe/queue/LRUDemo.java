package javatest.jihe.queue;

import com.apple.laf.AquaEditorPaneUI;
import sun.misc.LRUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUDemo {
    /**
     * 可以用双端队列很容易地解决LRU问题
     */
    private HashMap<Integer, LRUCache> map = new HashMap<>();

    private LRUCache head;
    private LRUCache tail;

    private int size;

    private int capacity;

    //如果使用 map 并且value是一个LRUCahce的双向队列，就可以保证每次访问的时候，移动删除map并且重新插入的成本是o（1）的
    class LRUCache{
        public LRUCache next;

        public LRUCache pre;

        public int capacity;

        public LRUCache(){}

        int key;
        int value;

        public Deque<Integer> queue = new LinkedList<>();;
        public LRUCache(int key, int value){
            this.key = key;
            this.value =value;
        }
    }


    public LRUDemo(int c) {
        capacity=c;
        head=new LRUCache();
        tail=new LRUCache();
        head.next=tail;
        tail.pre=head;
    }


    public int get(int key){
        LRUCache cache = map.get(key);
        if(cache==null){
            return -1;
        }
        removeAndAddToHead(cache);
        return cache.value;
    }

    public void put(int key, int value){
        LRUCache node =map.get(key);
        if(node!=null){
            moveToHead(node);
            node.value=value;
        }else{
            LRUCache n=new LRUCache(key,value);
            moveToHead(n);
            size++;
            //加入map
            map.put(key,n);
            if(size > capacity){
                //删除最近最少使用的元素
                removeTail(tail.pre);
                size--;
            }

        }
    }


    public void moveToHead(LRUCache node){
        LRUCache tmp = head.next;
        node.next = tmp;
        tmp.pre = node;
        head.next = node;
        node.pre = head;
    }

    //删除 双端队列尾部的元素
    public void removeTail(LRUCache node){
        LRUCache last=tail.pre;
        last.pre.next=last.next;
        last.next.pre=last.pre;
        map.remove(last.key);
    }


    public void removeAndAddToHead(LRUCache node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
        moveToHead(node);
    }
}
