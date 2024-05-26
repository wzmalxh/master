package thread.multi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadConditionPrintOptDemo {
    /**
     * 优化三个线程为一个线程，因为每个线程内部逻辑相似，因此需要独立完成这个抽象过程
     */

    private static int cnt = 0;
    private static int sum = 300;
    private static ReentrantLock lock = new ReentrantLock();

    static class ThreadFinal implements Runnable {

        private final Condition curCondition;

        private final Condition nextCondition;

        public ThreadFinal(Condition x, Condition y) {
            this.curCondition = x;
            this.nextCondition = y;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                //lock.lock();
                synchronized (lock) {
                    if (cnt % 3 == 0) {
                        System.out.print("A" + " ");
                    } else if (cnt % 3 == 1) {
                        System.out.print("B" + " ");
                    } else if (cnt % 3 == 2) {
                        System.out.println("C" + " ");
                    }
                    cnt += 1;
                    nextCondition.signal();

                    try {
                        curCondition.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();

        Thread t1 = new Thread(new ThreadFinal(c1, c2));
        Thread t2 = new Thread(new ThreadFinal(c2, c3));
        Thread t3 = new Thread(new ThreadFinal(c3, c1));

        t1.start();
        t2.start();
        t3.start();
    }
}
