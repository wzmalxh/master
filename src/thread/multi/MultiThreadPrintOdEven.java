package thread.multi;

public class MultiThreadPrintOdEven {
    private final static Object lock = new Object();

    private static  int count = 1;

    static class ThreadOdd implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while(count < 100){
                    while(count%2 != 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Thread1:"+count);
                    count+=1;
                    lock.notify();
                }

            }

        }
    }

    static  class ThreadEven implements Runnable{

        @Override
        public void run() {
            synchronized (lock){
                while(count < 100){
                    while(count%2 == 0){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println("Thread2:"+ count);
                    count+=1;
                    lock.notify();
                }

            }

        }
    }



    public static void main(String[] args) {
        Thread t = new Thread(new ThreadOdd());

        Thread t2 = new Thread(new ThreadEven());
        t.start();
        t2.start();
    }
}
