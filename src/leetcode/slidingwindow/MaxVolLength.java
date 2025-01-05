package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MaxVolLength {
    public int maxVowels(String s, int k) {
        //从左到右遍历
        if (s == null || s.length() == 0) {
            return 0;
        }
        char []ch = s.toCharArray();
        //长度为1
        List<Character> characterList = new ArrayList<>();
        characterList.add('a');
        characterList.add('e');
        characterList.add('i');
        characterList.add('o');
        characterList.add('u');
        int resultLength = 0;
        int left = 0;
        int count = 0;
        for(int right =0; right < ch.length; ) {
            while(right - left - 1 <= k) {
                if(characterList.contains(ch[right])) {
                    count ++;
                }
                right ++;
                if (count > resultLength) {
                    resultLength = count;
                }
            }
            //先判断是不是元音，再移动左边的窗口
            if(characterList.contains(ch[left])) {
                count --;
            }
            left ++;
        }
        return resultLength;
    }
}
