package javatest.jihe.queue;

import javatest.jihe.queue.demo.Customer;
import javatest.jihe.queue.demo.CustomerNew;
import javatest.jihe.queue.demo.CustomerWithoutSort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        /**
         * 另一种比较的方式
         */
        PriorityQueue<Customer> queue = new PriorityQueue<Customer> (new CustomerNew());

        queue.offer(new Customer(35000,"wang"));
        queue.offer(new Customer(36000,"duyan"));
        queue.offer(new Customer(4500,"wangyu"));
        queue.offer(new Customer(4600,"yuhong"));
        queue.offer(new Customer(70000,"wangzimeng"));

        System.out.println(queue.toString());


     /*   System.out.println("++++++++++++++++++");
        PriorityQueue<CustomerWithoutSort> queue2 = new PriorityQueue<>();
        queue2.offer(new CustomerWithoutSort(35000,"wang"));
        queue2.offer(new CustomerWithoutSort(36000,"duyan"));
        queue2.offer(new CustomerWithoutSort(4500,"wangyu"));
        queue2.offer(new CustomerWithoutSort(4600,"yuhong"));
        queue2.offer(new CustomerWithoutSort(70000,"wangzimeng"));
*/

        System.out.println("++++++++++++++++++");
        PriorityQueue<String> queue3 = new PriorityQueue<>();
        queue3.offer("wang");
        queue3.offer("duyan");
        queue3.offer("wangyu");
        queue3.offer("yuhong");
        queue3.offer("wangzimeng");
        System.out.println(queue3);
    }
}
