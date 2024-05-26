package javatest.fanxing;

import java.util.ArrayList;

public class FanXingInterfaceImpl implements FanXingInterface{
    @Override
    public String get() {
        return "Wang Zimeng";
    }

    public static void main(String[] args) {
        FanXingInterfaceImpl fanXingInterfaceImpl = new FanXingInterfaceImpl();
        System.out.println(fanXingInterfaceImpl.get());
        test();
    }



    public static void test() {
        ArrayList list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
