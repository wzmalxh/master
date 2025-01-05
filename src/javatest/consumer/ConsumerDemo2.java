package javatest.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo2 {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("Wang", "Zi", "Meng");

        Consumer<String> con2 = out -> System.out.print("会员姓名：" + out + ";");
        Consumer<String> con3 = str2 -> System.out.println("小写版本为: " + str2.toLowerCase());
        con2.andThen(con3);

        arr.stream().forEach(con2.andThen(con3)::accept);

    }
}
