package designmodel.decorate.impl;

import designmodel.decorate.Robot;

public class FirstRobot implements Robot {
    @Override
    public void doSomething() {
        System.out.println("唱");
        System.out.println("跳");
    }
}
