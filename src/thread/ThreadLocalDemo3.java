package thread;

public class ThreadLocalDemo3 {
    private static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            threadLocal.set("Thread 1 Value");
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
            threadLocal.remove();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        // 线程结束后，ThreadLocal 中的弱引用键允许对应的 Entry 被垃圾回收

        Thread.sleep(1000);

        // 再次尝试获取值，应该会返回 null，因为 ThreadLocalMap 中的 Entry 已经被垃圾回收
        System.out.println("After remove: " + threadLocal.get());
    }
}
