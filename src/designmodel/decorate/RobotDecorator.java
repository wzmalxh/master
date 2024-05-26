package designmodel.decorate;

import designmodel.decorate.Robot;

public class RobotDecorator implements Robot {

    private Robot robot;

    public RobotDecorator(Robot robot){
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
    }

    public void doMorething(){
        robot.doSomething();
        System.out.println("rap");
        System.out.println("篮球");
    }
}
