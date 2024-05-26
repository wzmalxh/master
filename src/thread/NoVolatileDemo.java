package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class NoVolatileDemo implements Runnable{

    static volatile int a = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);
    @Override
    public void run() {
        for(int i=0; i< 10000; i++){
            a++;
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new Thread(new NoVolatileDemo());
        Thread t2 =new Thread(new NoVolatileDemo());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("a = " + a);
        System.out.println("atomic integer is :"+ atomicInteger);
    }


}
