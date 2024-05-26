package javatest.jihe.map;

import java.util.HashMap;

public class HashMapDemo1 {
    public static void main(String[] args) {
        HashMap<String,String> hm = new HashMap<>();
        hm.put(null,"wang");
        hm.put(null, null);
        System.out.println(hm);
    }
}
