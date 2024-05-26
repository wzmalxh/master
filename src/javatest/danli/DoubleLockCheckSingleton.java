package javatest.danli;

public class DoubleLockCheckSingleton {
    private  volatile DoubleLockCheckSingleton singleton;

    /**
     * 构造方法必须私有，因为是通过getInstance访问
     */
    private DoubleLockCheckSingleton(){

    }

    private DoubleLockCheckSingleton getSingleton(){
        if(singleton == null) {
            synchronized (DoubleLockCheckSingleton.class){
                //当两个对象同时进入同步代码块的时候，确保singleton只初始化了一份
                if(singleton == null) {
                    singleton = new DoubleLockCheckSingleton();
                }
            }
        }
        return singleton;
    }
}
