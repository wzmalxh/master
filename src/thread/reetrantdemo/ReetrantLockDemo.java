package thread.reetrantdemo;

public class ReetrantLockDemo {
    public static void main(String[] args) {
        //说明synchronized的锁是可重入的
        final Object object = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    System.out.println("线程1外部调用+++++++");
                    synchronized (object){
                        System.out.println("线程1内部调用————————————");
                    }
                }
            }
        },"线程1").start();
    }
}
