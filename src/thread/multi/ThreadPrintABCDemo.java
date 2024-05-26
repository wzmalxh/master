package thread.multi;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintABCDemo {
    private static volatile int cnt = 0;
    private static Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    // 这里必须是while，不能是if，防止虚假唤醒的case
                    while (cnt % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("A");
                    cnt += 1;
                    lock.notifyAll();
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {

                    while (cnt % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("B");
                    cnt += 1;
                    lock.notifyAll();
                }
            }
        }
    }

    static class ThreadC implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    while (cnt % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("C");
                    cnt += 1;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadA());
        Thread t2 = new Thread(new ThreadB());
        Thread t3 = new Thread(new ThreadC());
        t1.start();
        t2.start();
        t3.start();
    }
}
