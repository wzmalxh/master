package thread.multi;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CyclicBarrierDemo {
    private static final int PARTIES = 3; // 线程数量
    private static final CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTIES);

    private static ReentrantLock lock = new ReentrantLock();

    private static int count = 0;

    static class ThreadPrint implements Runnable {

        private Condition curCondition;

        private Condition nextCondition;

        final int sum = 10;

        public ThreadPrint(Condition a, Condition b) {
            this.curCondition = a;
            this.nextCondition = b;
        }

        @Override
        public void run() {
            for (int i = 0; i < sum; i++) {
                lock.lock();
                if (count % 3 == 0) {
                    System.out.println("A");
                } else if (count % 3 ==1) {
                    System.out.println("B");
                }else if(count % 3 ==2){
                    System.out.println("C");
                }
                count += 1;
                nextCondition.signal();
                try {
                    curCondition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        Condition l1 = lock.newCondition();

        Condition l2 = lock.newCondition();

        Condition l3 = lock.newCondition();


        new Thread(new ThreadPrint(l1, l2)).start();
        new Thread(new ThreadPrint(l2, l3)).start();
        new Thread(new ThreadPrint(l3, l1)).start();
    }

    private static void print(char c, CyclicBarrier cyclicBarrier) {
        for (int i = 0; i < 10; i++) { // 假设打印10次
            try {
                System.out.print(c);
                cyclicBarrier.await(); // 等待其他线程打印
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
