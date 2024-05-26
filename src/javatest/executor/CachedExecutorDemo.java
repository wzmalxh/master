package javatest.executor;

import javax.lang.model.type.ExecutableType;
import java.util.concurrent.*;

public class CachedExecutorDemo {

     public static  ExecutorService executor  = Executors.newCachedThreadPool();

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("5555");
        Future<String> res = executor.submit(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Wangzimeng";
        });
        Thread.sleep(100);
        System.out.println(res.get());

    }
}
