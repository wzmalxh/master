package javatest.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    public static void main(String[] args) throws InterruptedException {

        ReentrantLock lock = new ReentrantLock(true);

        /**
         * 每次获取线程的顺序不固定，说明是非公平的lock锁
         */

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----线程:"+Thread.currentThread().getName()+"进来了");
                lock.lock();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        },"A");


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----线程:"+Thread.currentThread().getName()+"进来了");
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        }, "B");


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("-----线程:"+Thread.currentThread().getName()+"进来了");
                lock.lock();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            }
        }, "C");
         t1.start();
         Thread.sleep(200);
         t2.start();
         t3.start();
    }
}
