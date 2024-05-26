package thread.deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockDemo {

    public static void main(String[] args) {
         Object obj1 = new ReentrantLock();

         Object obj2 = new ReentrantLock();

         new Thread(new Runnable() {
             @Override
             public void run() {
                 synchronized (obj1){
                     System.out.println("锁对象1成功");
                     try {
                         Thread.sleep(4000);
                     } catch (InterruptedException e) {
                         throw new RuntimeException(e);
                     }
                     synchronized (obj2){
                         System.out.println("锁对象2成功");
                     }
                 }
             }
         }, Thread.currentThread().getName()).start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj2){
                    System.out.println("锁对象2成功");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (obj1){
                        System.out.println("锁对象1成功");
                    }
                }
            }
        }, Thread.currentThread().getName()).start();

    }
}
