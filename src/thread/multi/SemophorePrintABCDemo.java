package thread.multi;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SemophorePrintABCDemo {
    private static Semaphore semaphoreA = new Semaphore(1);
    private  static Semaphore semaphoreB = new Semaphore(0);

    private static Semaphore semaphoreC = new Semaphore(0);
    private static int count = 0;
   static class ThreadA implements Runnable{

        private Semaphore semaphoreCur;

        private Semaphore semaphoreNext;
        public ThreadA(Semaphore a, Semaphore  b){
            this.semaphoreCur = a;
            this.semaphoreNext  = b;
        }

        @Override
        public void run() {
            for(int i= 0 ;i < 10 ; i++){
                if(count % 3 ==0){
                    System.out.println("A");
                }else if(count % 3 == 1){
                    System.out.println("B");
                }else if(count % 3 ==2){
                    System.out.println("C");
                }
                count += 1;
                try {
                    semaphoreCur.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphoreNext.release();
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadA(semaphoreA,semaphoreB));
        Thread b = new Thread(new ThreadA(semaphoreB,semaphoreC));
        Thread c = new Thread(new ThreadA(semaphoreC,semaphoreA));
        a.start();
        b.start();
        c.start();
    }
}
