package javatest.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // todo 如果用普通的变量，禁止在多线程里做操作，因为线程不安全
        int count =0;
        for(int i=0; i< 10; i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int k =0 ; k < 10 ; k++){
                        atomicInteger.incrementAndGet();
                        System.out.println("当前线程为:"+Thread.currentThread().getName()+ "_"+ "数值大小="+atomicInteger);
                    }

                }
            });
            t.start();
        }
    }
}
