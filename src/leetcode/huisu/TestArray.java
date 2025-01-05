package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class TestArray {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("wang");
        arrayList.add("du");
        String []str = arrayList.toArray(new String[0]);
        for(int i=0; i< str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
