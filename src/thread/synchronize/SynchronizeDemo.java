package thread.synchronize;

public class SynchronizeDemo {

    public synchronized static void printOne()  {
        System.out.println("One");
        try{
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public synchronized  void printTwo(){
        System.out.println("Two");
    }

    public static void main(String[] args) {
        SynchronizeDemo synchronizeDemo = new SynchronizeDemo();
        SynchronizeDemo synchronizeDemo2 = new SynchronizeDemo();
        Thread ft1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeDemo.printOne();
            }
        });
        ft1.start();
        Thread ft2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizeDemo2.printTwo();
            }
        });
        ft2.start();
    }
}
