package thread.multi;

public class SynchronizedDemo {
    public synchronized void printA()  {
        try{
            Thread.sleep(1000);
            System.out.println("a is ...");
            Thread.sleep(2000);
            System.out.println("a is over");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public synchronized void printB()  {
        try{
            Thread.sleep(1000);
            System.out.println("b is ...");
            Thread.sleep(2000);
            System.out.println("b is over");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        Thread threadA = new Thread(() -> demo.printA());
        Thread threadB = new Thread(() -> demo.printB());
        threadA.start();
        threadB.start();


    }
}
