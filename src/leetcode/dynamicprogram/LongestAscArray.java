package leetcode.dynamicprogram;

import java.util.Arrays;

public class LongestAscArray {

    /**
     * 最长上升子序列
     * @param arr
     * @return
     */
    public static int longestAscArray(int [] arr){
        int []dp = new int [arr.length];
        int max= 0;
        Arrays.fill(dp,1);
        for(int i=1 ; i < arr.length; i++){
            for(int j= 0; j< i ; j++){
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    if(dp[i] > max){
                        max = dp[i];
                    }
                }
            }
        }
        return  max;
    }

    public static void main(String[] args) {
        int []arr = {6,3,1,5,2,3,7};
        System.out.println(longestAscArray(arr));
    }
}
