package designmodel.decorate;

import designmodel.decorate.impl.FirstRobot;

public class Testdemo {
    public static void main(String[] args) {
        FirstRobot r = new FirstRobot();
        RobotDecorator robotDecorator = new RobotDecorator(r);
        robotDecorator.doMorething();
    }
}
