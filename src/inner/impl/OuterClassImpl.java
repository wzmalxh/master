package inner.impl;

import inner.InnerClassDemo1;
import inner.InnerTest;
import inner.OuterClass;

public class OuterClassImpl implements OuterClass {

    public static String s1 = "this is s1 in Outer";
    public static String s2 = "this is s2 in Outer";
    private static String s3 = "this is s3 in Outer";

    public void method1(InnerTest inner) {
        inner.say("inner");
    }

    @Override
    public void syaOuter(InnerClassDemo1 classDemo1) {
        OuterClassImpl outer = new OuterClassImpl();

        outer.syaOuter(new InnerClassDemo1() {
            @Override
            public void say(String str) {
                System.out.println("Hello" + str);
            }
        });
    }

    public static void main(String[] args) {
        OuterClassImpl ou = new OuterClassImpl();
        ou.method1(new InnerTest() {
            @Override
            public void say(String str){
                System.out.println("Hello" + str);
            }
        });
    }
}
