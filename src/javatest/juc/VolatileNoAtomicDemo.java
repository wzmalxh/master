package javatest.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VolatileNoAtomicDemo {
    private volatile int count = 0;

    public void add() {
        count += 1;
    }

    public int get() {
        return this.count;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileNoAtomicDemo demo = new VolatileNoAtomicDemo();

        // 创建一个固定大小的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 提交任务到线程池，每个任务都会调用 increase() 方法
        for (int i = 0; i < 1000; i++) {
            executorService.submit(() -> {
                demo.add();
            });
        }

        // 关闭线程池并等待所有任务完成
        executorService.shutdown();
        executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);

        // 打印最终的 counter 值
        System.out.println("Final counter value: " + demo.count);
    }
}