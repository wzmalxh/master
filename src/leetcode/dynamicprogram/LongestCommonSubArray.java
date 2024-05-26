package leetcode.dynamicprogram;

public class LongestCommonSubArray {
    /**
     * 最长公共子串
     */
    public static int solution(int []num1, int []num2){
        if(num1 == null || num2 == null){
            return  0;
        }
        int row = num1.length;
        int column = num2.length;

        int [][]dp = new int[row+1][column+1];
        for(int i=0 ;i <= row; i++){
            dp[i][0] = 0;
        }
        for(int j=0 ; j<= column; j++){
            dp[0][j] = 0;
        }
        for(int i=1 ; i<= row ; i++){
            for(int j =1; j<= column ; j++){
                if(num1[i-1] == num2[j-1]){
                    dp[i][j] = 1 + Math.max(dp[i-1][j], dp[i][j-1]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[row-1][column-1];
    }

    public static void main(String[] args) {
        int []num1 = {1,3,5,7,8};
        int []num2 = {3,5,7,10};
        System.out.println(solution(num1,num2));
    }
}
