package javatest.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongDemo {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(5);
        AtomicLong atomicLong = new AtomicLong(0L);
        for(int i =0 ; i< 5 ; i++){
            new Thread(() -> {
                atomicLong.getAndIncrement();
                System.out.println("Thread Name is:"+Thread.currentThread().getName() + ", value is:"+atomicLong.get());
            }, Thread.currentThread().getName()+"_"+i).start();

            c.countDown();
        }
        try{
            c.await();
            System.out.println(atomicLong.get());
        }catch (Exception e){

        }
    }
}
