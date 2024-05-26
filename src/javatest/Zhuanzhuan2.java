package javatest;

public class Zhuanzhuan2 {
    private  int cnt;

    public int getCnt() {
        return cnt;
    }

    public synchronized void add() throws InterruptedException {
        Thread.sleep(1000);
        cnt ++;
        Thread.sleep(1000);
    }

    public static void main(String[] args) {
        Zhuanzhuan2 a = new Zhuanzhuan2();
        Zhuanzhuan2 b = new Zhuanzhuan2();

    }
}
