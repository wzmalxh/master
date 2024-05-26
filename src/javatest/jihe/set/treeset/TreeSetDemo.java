package javatest.jihe.set.treeset;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet ts=new TreeSet();

        //添加元素
        ts.add("abcjjj");
        ts.add("abb");
        ts.add("daccc");
        ts.add("gfg");
        ts.add("geee");
        ts.add("r");

        //进行迭代
        Iterator it=ts.iterator();

        //循环取出元素
        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }
}
