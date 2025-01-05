package javatest.consumer;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> str = strs -> System.out.println(strs.toUpperCase());
        Consumer<String> strSmaller = str2 -> System.out.println(str2.substring(0,6).toLowerCase());
        Consumer<String> printBoth = str.andThen(strSmaller);

        printBoth.accept("wangzimeng");

        Consumer<String> printBothAfter = str.andThen(printBoth);
        printBothAfter.accept("wangzimeng");

        testConsumer("wang", String::toLowerCase);

    }

    public static void testConsumer(String arg, Consumer<String> consumer) {
        System.out.println("In function testConsumer");
        consumer.accept(arg);
    }
}
