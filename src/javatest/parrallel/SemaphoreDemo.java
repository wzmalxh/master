package javatest.parrallel;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static Semaphore semaphoreA = new Semaphore(1);

    private static Semaphore semaphoreB = new Semaphore(0);

    private static Semaphore semaphoreC = new Semaphore(0);

    private static int cnt = 0;

    static class PrintThread implements Runnable{

        private Semaphore cur;

        private Semaphore next;



        public PrintThread(Semaphore cur, Semaphore next){
            this.cur = cur;
            this.next = next;
        }

        @Override
        public void run() {
            for(int i = 0; i< 10; i++){
                try {
                    cur.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(cnt % 3 == 0){
                    System.out.println("A");

                }else if(cnt % 3 == 1){
                    System.out.println("B");
                }else if(cnt % 3 ==2){
                    System.out.println("C");
                }
                cnt += 1;
                next.release();
            }

        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintThread(semaphoreA,semaphoreB));
        Thread t2 = new Thread(new PrintThread(semaphoreB,semaphoreC));
        Thread t3 = new Thread(new PrintThread(semaphoreC,semaphoreA));
        t1.start();
        t2.start();
        t3.start();

    }
}
