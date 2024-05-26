package leetcode;

import java.util.Arrays;

public class LongestAscSubString {
    public static int lengthOfLIS(int[] nums) {
        int []dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxLength =0;
        if(nums == null || nums.length <=1){
            return 1;
        }
        for(int i=0; i < nums.length-1; i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[j] > nums[i]){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                    if(dp[j] > maxLength){
                        maxLength = dp[j];
                    }
                }
            }
        }
        return maxLength;

    }

    public static void main(String[] args) {

    }
}
