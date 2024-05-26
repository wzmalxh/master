package thread;

public class ThreadLocalDemo2 {
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
        ThreadLocalDemo2 threadlocalDemo = new ThreadLocalDemo2();
        for (int i=0; i< 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadlocalDemo.setContent(Thread.currentThread().getName()+ "的数据");
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                    System.out.println(Thread.currentThread().getName()+":"+threadlocalDemo.getContent());
                }
            });
            t.start();
        }

    }
}

