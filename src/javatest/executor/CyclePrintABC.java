package javatest.executor;

import thread.multi.ThreadPrintABCDemo;

public class CyclePrintABC {

    public static int cnt = 0;
    public static Object lock = new Object();

    static class PrintAThread implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
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


    static class PrintBThread implements Runnable {
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


    static class PrintCThread implements Runnable {
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

    static class ThreadPrint extends Thread {
        private static final int A = 0;
        private static final int B = 1;
        private static final int C = 2;
        private static int currentChar = A; // 当前应该打印的字符的状态
        private static final Object lock = new Object(); // 锁对象

        public ThreadPrint(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    // 等待直到轮到自己打印
                    char name = getName().charAt(0);
                    while (currentChar % 3 != (name - 'A')) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    // 打印当前字符
                    System.out.print(this.getName().charAt(0));

                    // 更新状态并唤醒所有等待的线程
                    currentChar = (currentChar + 1) % 3;
                    lock.notifyAll();
                }
            }
        }

        public static void main(String[] args) {
            Thread t1 = new Thread(new PrintAThread());
            Thread t2 = new Thread(new PrintBThread());
            Thread t3 = new Thread(new PrintCThread());
            t1.start();
            t2.start();
            t3.start();


            new ThreadPrint("A").start();
            new ThreadPrint("B").start();
            new ThreadPrint("C").start();
        }
    }
}
