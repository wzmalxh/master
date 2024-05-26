package javatest.jihe.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueByLinkedListDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("wangzimeng");
        queue.offer("duyan");

        System.out.println(queue.peek());
        queue.poll();
        System.out.println("0----------------");
        System.out.println(queue.peek());
    }
}
