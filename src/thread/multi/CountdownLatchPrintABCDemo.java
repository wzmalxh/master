package thread.multi;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchPrintABCDemo {

    public static void main(String[] args) throws InterruptedException {
        int loopCount = 10; // 设置循环次数
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(1);
        CountDownLatch countDownLatchC = new CountDownLatch(1);

        Runnable taskAPrint = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (count < loopCount) {
                    try {
                        count++;
                        countDownLatchA.await();
                        System.out.print("A");
                        countDownLatchB.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable taskBPrint = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (count < loopCount) {
                    try {
                        count++;
                        countDownLatchB.await();
                        System.out.print("B");
                        countDownLatchC.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable taskCPrint = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (count < loopCount) {
                    try {
                        count++;
                        countDownLatchC.await();
                        System.out.print("C");
                        countDownLatchA.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread threadA = new Thread(taskAPrint, "Thread-0");
        Thread threadB = new Thread(taskBPrint, "Thread-1");
        Thread threadC = new Thread(taskCPrint, "Thread-2");

        threadA.start();
        threadB.start();
        threadC.start();

        countDownLatchA.countDown(); // 开始循环
    }
}

