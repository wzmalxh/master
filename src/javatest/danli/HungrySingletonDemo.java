package javatest.danli;

public class HungrySingletonDemo {
    private static HungrySingletonDemo hungrySingletonDemo = new HungrySingletonDemo();
    private HungrySingletonDemo(){

    }

    public HungrySingletonDemo getInstance(){
        return hungrySingletonDemo;
    }
}
