package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallerRunsPolicy {
    public static void main(String[] args) {
        // 创建一个固定大小的线程池，并设置拒绝策略为CallerRunsPolicy
        ExecutorService executor = new ThreadPoolExecutor(
                3, // 核心线程数
                5, // 最大线程数
                60, // 空闲线程存活时间
                TimeUnit.SECONDS, // 时间单位
                new java.util.concurrent.LinkedBlockingQueue<Runnable>(), // 任务队列,
        new ThreadPoolExecutor.CallerRunsPolicy()
        );
        System.out.println(Thread.currentThread().getName());
        // 提交10个任务到线程池
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running by thread " + Thread.currentThread().getName());
                try {
                    Thread.sleep(20000); // 模拟任务执行耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.shutdown();
    }
}

