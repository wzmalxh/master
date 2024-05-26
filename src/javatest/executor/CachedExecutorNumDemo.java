package javatest.executor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CachedExecutorNumDemo {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executors;
        AtomicInteger activeThreads = new AtomicInteger(threadPoolExecutor.getActiveCount());

        for (int k = 0; k < 20; k++) {
            final int taskId = k;
            executors.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " is running by thread " + Thread.currentThread().getName());
                    activeThreads.set(threadPoolExecutor.getActiveCount());
                    System.out.println("活跃线程数量= " + activeThreads);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("活跃线程数量= " + activeThreads);
        executors.shutdown();

        List<String> nameList = Arrays.asList("Wang Zimeng", "Chen Yidan");

        List<CompletableFuture<String>> futures = new ArrayList<>();
        for(int i=0; i < nameList.size(); i++){
            int finalI = i;
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello World").thenApply(s -> s + nameList.get(finalI));
            futures.add(completableFuture);
        }


        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        // 当所有任务都完成时，我们可以开始处理结果
        allFutures.thenRun(() -> {
            // 这里可以使用非阻塞的方式处理结果，比如打印到控制台或进行其他操作
            for (CompletableFuture<String> future : futures) {
                try {
                    // 使用join方法获取结果，它不会抛出ExecutionException或InterruptedException
                    System.out.println(future.join());
                } catch (CompletionException e) {
                    // 如果某个任务执行时发生了异常，这里会捕获到CompletionException
                    e.printStackTrace();
                }
            }
        });

    }
}
