package thread.multi;

import java.util.LinkedList;
import java.util.Queue;

public class ReenterantlockMyselfDemo {
    private int readers = 0;

    private Thread writer  = null;

    private int writeHolds = 0; // 写锁的重入次数
    private int readHolds = 0; // 读锁的重入次数（尽管在实际中，读锁通常不需要重入计数，因为多个线程可以同时持有读锁）

    /**
     * 如果是公平锁模式，需要引入队列
     */
    private Queue<Thread> readQueue = new LinkedList<>();


    private Queue<Thread> writeQueue = new LinkedList<>();

    // 获取读锁
    public void lockRead() {
        Thread current = Thread.currentThread();
        if (writer == current) {
            readHolds++; // 当前线程已经是写锁持有者，可以重入读锁
        } else {
            while (writer != null) {
                // 等待写锁释放
                try {
                    Thread.sleep(1); // 简单的自旋等待，实际应用中应该使用更复杂的等待策略
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            readers++;
        }
    }

    // 释放读锁
    public void unlockRead() {
        Thread current = Thread.currentThread();
        if (writer == current) {
            if (readHolds > 0) {
                readHolds--;
            }
        } else {
            if (readers > 0) {
                readers--;
            }
        }
    }

    // 获取写锁
    public void lockWrite() {
        Thread current = Thread.currentThread();
        if (writer == current) {
            writeHolds++; // 当前线程已经是写锁持有者，可以重入写锁
        } else {
            while (writer != null || readers > 0) {
                // 等待读锁和写锁都释放
                try {
                    Thread.sleep(1); // 简单的自旋等待，实际应用中应该使用更复杂的等待策略
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e);
                }
            }
            writer = current;
        }
    }

    // 释放写锁
    public void unlockWrite() {
        Thread current = Thread.currentThread();
        if (writer == current) {
            if (writeHolds > 0) {
                writeHolds--;
                if (writeHolds == 0) {
                    writer = null;
                }
            }
        }
    }




    public void fairLockRead(){

    }
}


