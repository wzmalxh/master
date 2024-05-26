package thread.multi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private static ReentrantLock lock = new ReentrantLock();

    private static Condition conditionA = lock.newCondition();

    private static Condition conditionB = lock.newCondition();

    private static Condition conditionC = lock.newCondition();

    private static int cnt = 0;


    public void printA(int num) {
        lock.lock();
        try {
            for (int i = 0; i < num; i++) {
                if (cnt % 3 != 0) {
                    conditionA.await();
                }

                System.out.println("A");
                cnt = 1;
                conditionB.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void printB(int num) {

        lock.lock();
        try {
            for (int i = 0; i < num; i++) {
                if (cnt % 3 != 1) {
                    conditionB.await();
                }

                System.out.println("B");
                cnt = 2;
                conditionC.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(int num) {

        lock.lock();

        try {
            for (int i = 0; i < num; i++) {
                if (cnt % 3 != 2) {
                    conditionC .await();
                }
                System.out.println("C");
                cnt = 0;
                conditionA.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

   /* static class ThreadPrintABC implements Runnable {

        private Condition cur;

        private Condition next;

        public ThreadPrintABC(Condition a, Condition b) {
            this.cur = a;
            this.next = b;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                if (cnt % 3 == 0) {
                    System.out.println("A");
                } else if (cnt % 3 == 1) {
                    System.out.println("B");
                } else if (cnt % 3 == 2) {
                    System.out.println("C");
                }
                cnt++;
                try {
                    cur.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                next.signal();
            }
        }
    }*/

    public static void main(String[] args) {
        ConditionDemo c = new ConditionDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printA(10);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printB(10);
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                c.printC(10);
            }
        });

        t1.start();
        t2.start();
        t3.start();


    }
}
