package javatest.danli;

public class LazySingletonDemo {

    private static LazySingletonDemo lazySingletonDemo;
    private LazySingletonDemo(){

    }

    public LazySingletonDemo getInstance(){
        if (lazySingletonDemo == null){
            lazySingletonDemo = new LazySingletonDemo();
        }
        return lazySingletonDemo;
    }
}
