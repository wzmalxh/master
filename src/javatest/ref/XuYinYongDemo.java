package javatest.ref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class XuYinYongDemo {
    public static void main(String[] args) {
        Object ob = new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        /**
         * 虚引用必须有一个引用队列，gc运行回收对象时如果发现是虚引用，将对象放入引用队列
         */
        PhantomReference<String> phantomReference = new PhantomReference(ob, referenceQueue);

        if (phantomReference.get() == null){
            System.out.println("是一个虚引用");
        }else{
            System.out.println("不是一个虚引用");
        }

    }
}
