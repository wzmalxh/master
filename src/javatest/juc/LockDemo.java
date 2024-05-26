package javatest.juc;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    static int tickets = 100;

    public static void main(String[] args) {
        //代表共享对象，只初始化一份
        TicketsSell ticketsSell = new TicketsSell(tickets);
        //三个线程共同完成票数俄的扣减
        new Thread(ticketsSell).start();
        new Thread(ticketsSell).start();
        new Thread(ticketsSell).start();
    }

    static class TicketsSell implements  Runnable{

        private int tickets;
        ReentrantLock lock = new ReentrantLock();
        public  TicketsSell(int t){
            this.tickets = t;
        }

        @Override
        public void run() {
            while(true) {
                lock.lock();
                try{
                    if(tickets > 0){
                        System.out.println("余票数量为:"+ (--tickets));
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }

            }
        }
    }
}
