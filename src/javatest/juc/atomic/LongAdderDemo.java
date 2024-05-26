package javatest.juc.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderDemo {
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(10);
        long l = 0L;
        LongAdder longAdder = new LongAdder();
        final int times = 100;
        Thread []t = new Thread[10];

        for(int k=0 ; k< t.length ; k++){
            t[k] = new Thread(() -> {
                for(int i = 0; i < times; i++){
                    longAdder.increment();
                    //如果使用普通变量，会显示地提示编译错误
                    // todo l+= 1;
                }
                c.countDown();
            }, "thread"+"_"+ k);
            t[k].start();
        }
        try{
            c.await();
        }catch (Exception e){

        }finally {
            System.out.println("After sum longAdder value is :"+longAdder.sum());
        }
    }
}
