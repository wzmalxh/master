package javatest.lambda;

import java.util.*;
import java.util.stream.Collectors;

public class TestLambdaDemo {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        map.put(6,1);
        Map<String,Integer> mapStr = new HashMap<>();
        mapStr.put("1",1);
        mapStr.put("2",1);
        mapStr.put("3",1);
        mapStr.put("4",1);
        mapStr.put("5",1);
        mapStr.put(null,1);
        List<String> str = new ArrayList<>(mapStr.keySet());
        List<Integer> m = mapStr.keySet().stream().filter(Objects::nonNull).collect(Collectors.toList()).stream().map(x -> Integer.parseInt(x)).filter(x -> x%2 ==0 ).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(int i =0 ;i < m.size(); i++){
            System.out.println(m.get(i));
        }
    }
}
