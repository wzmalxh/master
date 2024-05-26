package thread.threadpool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StringNoRepeatDemo {
    public static void main(String[] args) {
        StringNoRepeatDemo demo = new StringNoRepeatDemo();
        int result = demo.longestNoRepeatWords("abccdd");
        System.out.println(result);
    }

    public int longestNoRepeatWords(String str){
        int maxLength = Integer.MIN_VALUE;
        if(str == null || str.isEmpty()){
            return  0;
        }
        Set<Character> set = new HashSet<>();
        for(int i = 0, j =0; i < str.length() && j < str.length(); ){
            if(!set.contains(str.charAt(j))){
                set.add(str.charAt(j));
                j+=1;
            }else{
                set.remove(str.charAt(i));
                i+=1;
            }
            maxLength = Math.max(set.size(),maxLength);
        }
        return maxLength;
    }
}
