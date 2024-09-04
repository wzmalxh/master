package leetcode.huisu;

import java.util.HashMap;
import java.util.Map;

public class NumToCharacter {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 解码
     *
     * @param nums string字符串 数字串
     * @return int整型
     */

    public static int solve (String nums) {
        return dfsNums(nums, 0);
    }
    // 递归函数
    public static int dfsNums(String nums, int start){
        //当start走到终点时，证明已经解码完毕，直接返回1
        if(start == nums.length()){
            return 1;
        }
        //当字符为0的时候，0没对应的解码，所以直接返回0 (此路解码废掉)
        if(nums.charAt(start) == '0')
            return 0;
        //每次解码一个字符
        int res1 = dfsNums(nums,start+1);
        int res2 =0;

        //如果当前字符等于1 或者 当前字符加上下一个字符合起来小于等于26 则可以一次解码两个字符
        if(start + 1 < nums.length()) {
            int value = Integer.parseInt(nums.substring(start,start+2));
            if (value <= 26) {
                res2 = dfsNums(nums,start+2);
            }
        }
        //返回结果
        return res1 + res2;
    }

    public static void main(String[] args) {
        String num = "123";
        System.out.println(solve(num));
    }
}
