package threads;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.concurrent.*;

public class ConcurrentHashMapDemo {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300), new ThreadFactory() {
        @Override
        public Thread newThread(@NotNull Runnable r) {
            return null;
        }
    }, new ThreadPoolExecutor.DiscardOldestPolicy());

    private HashMap<String,Integer> hm = new HashMap<>();

    public static void main(String[] args) throws Exception {
        ConcurrentHashMap<String,String> cn = new ConcurrentHashMap<>();
        cn.put("Chen","wangzimeng");
        System.out.println(cn.toString());

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            cn.put("zimeng","wang");
            cn.put("yan","du");
        });


        Future<ConcurrentHashMap<String,String>> future = executorService.submit(() -> {
            cn.put("a","wang");
            cn.put("yan","du");
            Thread.sleep(2000);
            return cn;
        });
        try{
            ConcurrentHashMap<String,String> con = null;
            while (con == null){
                con = future.get();
            }
            System.out.println(con.toString());
        }catch (Exception e){
            throw new Exception("多线程执行失败");
        }


    }
}
