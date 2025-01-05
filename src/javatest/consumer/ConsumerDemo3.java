package javatest.consumer;

import java.util.function.Consumer;

public class ConsumerDemo3 {

    public static void processData(int[] data, Consumer<Integer> consumer) {
        for (int num : data) {
            consumer.accept(num);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        // 传递Consumer函数式接口作为参数，实现对数组元素的打印操作
        processData(numbers, System.out::println);

        Consumer<String> stringProcessor = getStringProcessor();

        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String st) {
                System.out.println("处理后的字符串: " + st.toUpperCase());
            }
        };
        stringProcessor.accept("hello");
        stringConsumer.accept("world");
    }

    public static Consumer<String> getStringProcessor() {
        return str -> System.out.println("处理后的字符串: " + str.toUpperCase());
    }
}
