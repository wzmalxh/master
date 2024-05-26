package javatest.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        int count = 0;
        System.out.println("1111");
        lock.lock();
        try{
            count +=1;
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
