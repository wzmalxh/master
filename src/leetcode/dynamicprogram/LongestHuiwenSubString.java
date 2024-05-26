package leetcode.dynamicprogram;

public class LongestHuiwenSubString {
    public static void main(String[] args) {
        String str = "ac";
        System.out.println(longestHuiWenSubString(str));
        System.out.println(longestHuiWenSubStringStr(str));
    }

    public static int longestHuiWenSubString(String str){
        int n =str.length();
        boolean [][]dp = new boolean[n][n];
        if(str.length() < 2){
            //长度为1，一定是回文字符串
            return  str.length();
        }
        int maxLen = 0;
        for(int right = 1; right < n ; right ++) {
            for(int left = 0 ; left <= right; left ++){
                if (str.charAt(left) != str.charAt(right))
                    continue;
                if(str.charAt(left) == str.charAt(right)){
                    if((right - left )<= 2) {
                        dp[left][right] = true;
                    }else{
                        //这就是外层right循环必须从1开始的原因
                        dp[left][right] = dp[left+1][right-1];
                    }
                    if(dp[left][right] && (right -left +1) > maxLen){
                        maxLen = right - left +1;
                    }
                }
            }
        }
        return maxLen;
    }






    public static String longestHuiWenSubStringStr(String str){
        int n =str.length();
        boolean [][]dp = new boolean[n][n];
        if(str.length() < 2){
            //长度为1，一定是回文字符串
            return  str;
        }
        String res = "";
        int maxLen = 0;
        for(int right = 1; right < n ; right ++) {
            for(int left = 0 ; left <= right; left ++){

                if (str.charAt(left) != str.charAt(right))
                    continue;

                if(str.charAt(left) == str.charAt(right)){
                    if((right - left )<= 2) {
                        dp[left][right] = true;
                    }else{
                        //这就是外层right循环必须从1开始的原因
                        dp[left][right] = dp[left+1][right-1];
                    }
                    StringBuilder stringBuilder= new StringBuilder();
                    if(dp[left][right] && (right -left +1) > maxLen){
                        maxLen = right - left +1;
                        res = str.substring(left,right+1);
                    }
                }
            }
        }

        return res;

    }
}
