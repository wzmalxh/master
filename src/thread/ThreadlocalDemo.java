package thread;

public class ThreadlocalDemo {

    private static String content;


    private static ThreadLocal<String> threadLocalContent = new ThreadLocal<>();

    public static String getContent(){
        //return content;
        String str = threadLocalContent.get();
        return str;
    }

    public static void setContent(String cont){
      /*  content = cont;*/
        threadLocalContent.set(cont);
    }

    public static void main(String[] args) {
        ThreadlocalDemo threadlocalDemo = new ThreadlocalDemo();
        for (int i=0; i< 10; i++) {
            Thread t = new Thread(() -> {
                threadlocalDemo.setContent(Thread.currentThread().getName()+ "的数据");
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                System.out.println(Thread.currentThread().getName()+":"+threadlocalDemo.getContent());
            });
            t.setName("线程"+ i);
            t.start();
        }
    }
}
