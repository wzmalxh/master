package leetcode.shuzu;

import java.util.Arrays;
import java.util.HashSet;

public class LongestStringSubArray {
    public static void main(String[] args) {
        int []num = {0,3,5,6,7,8,2,4,9,1};
        int n = longestSubArraySequence(num);
        System.out.println(n);
    }

    public static int longestSubArraySequence(int []nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i< nums.length; i++){
            set.add(nums[i]);
        }
        int maxLength = 0;
        //去重
        int []tmp = new int[nums.length];
        Arrays.fill(tmp,1);
        for(int i=0; i< nums.length ; i++){
            if(!set.contains(nums[i] - 1)){
                tmp[i] = 1;
            }else{
                while (set.contains(nums[i]+1)){
                    tmp[i] += 1;
                    nums[i] = nums[i]+1;
                }

            }
            if(tmp[i] > maxLength){
                maxLength = tmp[i];
            }
        }
        return maxLength;
    }
}
