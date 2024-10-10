package leetcode.math;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class IsHappyNumber {
    public static boolean isHappy(int n) {
        int value = 0;
        int mod = 0;
        ArrayList<Integer> nList = new ArrayList<>();
        while(n >= 10) {
            value = n/10;
            mod = n%10;
            n = value;
            nList.add(mod);
        }
        nList.add(value);
        int sum = 0;
        for(int i=0 ;i< nList.size(); i++) {
            sum += nList.get(i) * nList.get(i);
        }
        if(sum == 1) {
            return true;
        } else {
            return sum >= Integer.MAX_VALUE ? false : isHappy(sum);
        }
    }


    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }


}
