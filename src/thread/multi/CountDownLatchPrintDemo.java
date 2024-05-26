package thread.multi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class CountDownLatchPrintDemo {
    private static CountDownLatch countDownLatchA = new CountDownLatch(1);
    private static CountDownLatch countDownLatchB = new CountDownLatch(1);

    private static CountDownLatch countDownLatchC = new CountDownLatch(1);

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread tA = new Thread(new printThread("A"));
        Thread tB = new Thread(new printThread("B"));
        Thread tC = new Thread(new printThread("C"));
        tA.start();
        tB.start();
        tC.start();
        countDownLatchA.await();
    }


    static class printThread implements Runnable{

        private String str;

        public printThread(String s){
            this.str = s;
        }

        @Override
        public void run() {
            synchronized (lock){
                for(int i=0 ; i< 10 ; i++){
                    try {
                        countDownLatchA.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(str);
                    countDownLatchA.countDown();
                }
            }
        }
    }
}
