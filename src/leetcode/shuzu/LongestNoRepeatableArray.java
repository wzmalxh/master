package leetcode.shuzu;

import java.util.HashSet;
import java.util.Set;


public class LongestNoRepeatableArray {

    public static int longestArrayNoSame(int []array){
        Set<Integer> set = new HashSet<>();
        int max = 0;
        if (array == null || array.length ==0){
            return max;
        }
        int left =0;
        int right =0;
        while(left < array.length && right < array.length) {
            while (set.contains(array[right])) {
                set.remove(array[left]);
                left++;
            }
            set.add(array[right++]);
            if(set.size() > max){
                max = set.size();
            }
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
