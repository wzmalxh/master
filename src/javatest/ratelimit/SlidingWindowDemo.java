package javatest.ratelimit;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class SlidingWindowDemo {
    private long windowStart = System.currentTimeMillis();

    //滑动窗口的单位（小）窗口长度
    private long windowSize;

    //限流最大的请求数量
    private int maxRequest;


    private Map<Long, LongAdder> windowCount = new ConcurrentHashMap<>();


    public SlidingWindowDemo(int maxRequests, long windowSizeInMs) {
        this.maxRequest = maxRequests;
        this.windowSize = windowSizeInMs;
        this.windowCount = new ConcurrentHashMap<>();
    }

    public boolean tryAcquire() {
        long currentTimeMillis = System.currentTimeMillis();
        long windowEnd = windowStart + windowSize;
        if (windowEnd < System.currentTimeMillis()) {
            //重新计数
            windowStart = System.currentTimeMillis();
            windowCount.clear();
        }
        long windowId = currentTimeMillis - (currentTimeMillis % windowSize);
        LongAdder count = windowCount.computeIfAbsent(windowId, k -> new LongAdder());
        // 尝试增加计数
        count.increment();
        // 检查是否超过限制
        return count.longValue() <= maxRequest;

    }

    public static void main(String[] args) {
        SlidingWindowDemo rateLimiter = new SlidingWindowDemo(2, 1000); // 窗口容量为10，窗口大小为1秒

        // 模拟请求
        for (int i = 0; i < 10; i++) {
            // 模拟请求之间的时间间隔
            try {
                TimeUnit.MILLISECONDS.sleep(200); // 每个请求间隔200毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 尝试获取限流器
            boolean acquired = rateLimiter.tryAcquire();
            System.out.println("Request " + (i + 1) + ": " + (acquired ? "Acquired" : "Denied"));
        }
    }

}
