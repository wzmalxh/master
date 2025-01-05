package javatest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("aaa");
        list.add("bbb");
        list.add(null);

        list.forEach(temp -> {
            Optional<String> opt = Optional.ofNullable(temp);
            System.out.println(opt.map(String::toUpperCase).orElse("Nothing"));
        });

        // 简写为如下形式
        list.forEach(temp -> {
            System.out.println(Optional.ofNullable(temp).map(String::toUpperCase).orElse("Nothing"));
        });


        // 自己指定异常
        System.out.println((Optional.ofNullable("a")));
        System.out.println((Optional.ofNullable(null).orElseGet(() -> "wangzimeng")));


    }
}
