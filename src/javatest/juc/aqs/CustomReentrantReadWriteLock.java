package javatest.juc.aqs;

import java.util.LinkedList;
import java.util.Queue;

public class CustomReentrantReadWriteLock {
    private int readHoldCount;
    private int writeHoldCount;
    private Thread readingThread;
    private Thread writingThread;
    private int waitingReaders;
    private int waitingWriters;

    // 用于读锁的等待队列
    private final Queue<Thread> readersWaitQueue = new LinkedList<>();
    // 用于写锁的等待队列
    private final Queue<Thread> writersWaitQueue = new LinkedList<>();

    public void acquireReadLock() throws InterruptedException {
        Thread current = Thread.currentThread();
        if (writingThread != null && !writingThread.equals(current)) {
            // 如果有写锁被持有且不是当前线程，则等待
            synchronized (this) {
                waitingReaders++;
                while (writingThread != null && !writingThread.equals(current)) {
                    wait();
                }
                waitingReaders--;
            }
        }

        synchronized (this) {
            while (readHoldCount == 0 && writingThread != null) {
                // 如果没有读锁被持有且有写锁被持有，则等待
                readersWaitQueue.add(current);
                waitingReaders++;
                wait();
                waitingReaders--;
                readersWaitQueue.remove(current);
            }
            readHoldCount++;
            if (readHoldCount == 1) {
                readingThread = current;
            }
        }
    }

    public void releaseReadLock() {
        Thread current = Thread.currentThread();
        synchronized (this) {
            if (readingThread == current) {
                readHoldCount--;
                if (readHoldCount == 0) {
                    readingThread = null;
                    if (waitingWriters > 0) {
                        // 如果有等待的写锁请求，则通知一个写线程
                        notifyAll();
                    } else if (!readersWaitQueue.isEmpty()) {
                        // 否则，通知等待的读线程
                        readersWaitQueue.peek().notify();
                    }
                }
            }
        }
    }

    public void acquireWriteLock() throws InterruptedException {
        Thread current = Thread.currentThread();
        synchronized (this) {
            while (readHoldCount > 0 || writingThread != null && !writingThread.equals(current)) {
                // 如果有读锁被持有或有写锁被其他线程持有，则等待
                writersWaitQueue.add(current);
                waitingWriters++;
                wait();
                waitingWriters--;
                writersWaitQueue.remove(current);
            }
            writingThread = current;
            writeHoldCount++;
        }
    }

    public void releaseWriteLock() {
        Thread current = Thread.currentThread();
        synchronized (this) {
            if (writingThread == current) {
                writeHoldCount--;
                if (writeHoldCount == 0) {
                    writingThread = null;
                    if (waitingWriters > 0) {
                        // 如果有等待的写锁请求，则通知一个写线程
                        notifyAll();
                    } else if (readersWaitQueue.size() > 0) {
                        // 否则，通知等待的读线程
                        readersWaitQueue.peek().notify();
                    }
                }
            }
        }
    }
}
