package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JingDongDemo {
    public static String lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s;
        }
        //定义窗口的最大值
        int longestLength = 0;
        //定义左右指针
        int left = 0;
        int right = 0;
        int b=0, e = 0;
        //定义窗口字符集合
        Set<Character> set = new HashSet<>();
        //当左右指针到达边界值时结束循环
        while (left < s.length() && right < s.length()) {
            //判断窗口集合是否包含指针处字符
            if (set.contains(s.charAt(right))) {
                //包含就移除集合中指针处字符，并右移左指针
                set.remove(s.charAt(left));
                left++;
            } else {
                //不包含就将指针处字符添加到集合中，并右移右指针
                set.add(s.charAt(right));
                right++;
            }
            //更新窗口最大值
            if (set.size() > longestLength) {
                longestLength = set.size();
                b = left;
                e = right;
            }
        }
        return s.substring(b, e);
    }


    public static void main(String[] args) {
        String str  ="abcdfkljhhioyvvnkhytrdchvjvjhrddedv";
        System.out.println(lengthOfLongestSubstring(str));
    }


}
