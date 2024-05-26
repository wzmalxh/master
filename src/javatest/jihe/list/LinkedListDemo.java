package javatest.jihe.list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("1314");
        list.add("Duyan");
        list.remove();
        System.out.println(list);
        System.out.println("+++++++");
        // 修改
        list.set(0,999);
        list.add("wangzimeng");
        System.out.println(list);

    }
}
