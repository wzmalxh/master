package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestNoRepeatSubString {
    public String lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        String res = "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0,j =0; j< s.length(); j++){
            char ch = s.charAt(j);
            if(map.containsKey(ch)){
                //更新起始位置的下标
                if(map.get(s.charAt(j)) > i){
                    i = map.get(ch);
                }
            }
            map.put(ch, j+1);
            if(j-i +1 > maxLength){
                maxLength = j- i+1;
                res = s.substring(i,j+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestNoRepeatSubString r = new LongestNoRepeatSubString();
        System.out.println(r.lengthOfLongestSubstring("abcabcbb"));
    }



}
