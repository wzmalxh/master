package javatest.juc;

public class VolatileNoAtomicDemoTest {
    public static void main(String[] args) throws InterruptedException {
        VolatileNoAtomicDemo demo = new VolatileNoAtomicDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i< 100; i++){
                    demo.add();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i< 100; i++){
                    demo.add();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0 ;i< 100; i++){
                    demo.add();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("最终值="+ demo.get());
    }
}
