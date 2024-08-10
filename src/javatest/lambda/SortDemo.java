package javatest.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,2,4,5,6,3,12,10);

        nums = nums.stream().map(ele -> ele * 2-1).sorted().collect(Collectors.toList());

        for(int i = 0; i< nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        //常规比较器
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        nums.sort((o1, o2) -> o1 - o2);

        //或者在lambda表达式中 使用
    }
}
