package completablefuture;

public class TestThread1 {
    static class ThreadPO extends Thread {

        private String name;

        public ThreadPO(String n) {
            this.name = n;
        }


        @Override
        public void run() {
            System.out.println("测试线程的运行效果: "+ name);
            try {
                Thread.sleep(1000);
                System.out.println(": "+ name);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {

            }

        }
    }

    public static void main(String[] args) {
        ThreadPO t = new ThreadPO("结算文件");
        System.out.println("开始计算结算文件");
        t.start();


    }
}
