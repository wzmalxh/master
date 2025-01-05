package javatest.consumer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,43);
        Function<Integer,String> func = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return String.valueOf(integer);
            }
        };
        list.stream().forEach(li -> {
            System.out.println(func.apply(li));
        });

        Function<Integer,String> funcLLambda = integer -> String.valueOf(integer);

        List<Integer> nums = Arrays.asList(1,5,3,7,11,6,2);
        nums.sort((i1, i2) -> i2- i1);

        nums.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

        Supplier<String> supplier =  () -> {
              return "Hello World";
        };
    }
}
