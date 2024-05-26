package javatest.kuaishou;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        AtomicInteger count = new AtomicInteger(10);
        executorService.execute(() -> {
            for(int i=0; i< 100; i++){
                count.addAndGet(i);
            }
        });
        System.out.println(count);
        Map<String,String> map = new HashMap<>();
        Thread.sleep(1000);
        System.out.println(count);


        int ss = sumAndParallelCompute(5,executorService);
        System.out.println(ss);
    }

    public static int sumAndParallelCompute(int threads, ExecutorService executor){
        AtomicInteger num = new AtomicInteger(0);
        try{
            for(int i=0 ; i< threads; i++){
                Future<?> future = executor.submit(() -> {
                    for(int k=0; k< 5; k++){
                        num.addAndGet(k);
                    }
                }, i);
                future.get();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
        return num.get();
    }
}
