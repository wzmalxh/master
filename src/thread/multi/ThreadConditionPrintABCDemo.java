package thread.multi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadConditionPrintABCDemo {

    private static int cnt = 0;

    private static ReentrantLock lock = new ReentrantLock();

    static class ThreadA implements  Runnable{

        private final Condition curCondition ;

        private final Condition nextCondition;

        public ThreadA(Condition A, Condition B){
            this.curCondition = A;
            this.nextCondition = B;
        }

        @Override
        public void run() {
            while(true) {
                lock.lock();
                if(cnt % 3 == 0){
                    System.out.println("A");
                    cnt +=1;
                }
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


    static class ThreadB implements  Runnable{

        private final Condition curCondition ;

        private final Condition nextCondition;

        public ThreadB(Condition B, Condition C){
            this.curCondition = B;
            this.nextCondition = C;
        }

        @Override
        public void run() {

            while(true) {
                lock.lock();
                if(cnt % 3 == 1){
                    System.out.println("B");
                    cnt +=1;
                }
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


    static class ThreadC implements  Runnable{

        private final Condition curCondition ;

        private final Condition nextCondition;

        public ThreadC(Condition C, Condition A){
            this.curCondition = C;
            this.nextCondition = A;
        }

        @Override
        public void run() {

            while(true) {
                lock.lock();
                if(cnt % 3 == 2){
                    System.out.println("C");
                    cnt +=1;
                }
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
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        Thread t1 = new Thread(new ThreadA(conditionA,conditionB));
        Thread t2 = new Thread(new ThreadB(conditionB,conditionC));
        Thread t3 = new Thread(new ThreadC(conditionC,conditionA));

        t1.start();
        t2.start();
        t3.start();
    }
}
