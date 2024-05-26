package leetcode;

public class LongestHuiwenSubStringDemo {
    public static void main(String[] args) {
        LongestHuiwenSubStringDemo demo= new LongestHuiwenSubStringDemo();
        System.out.println(demo.longestSubString("abbbacedgb"));
    }

    public String longestSubString(String str){
        if(str == null || str.isEmpty()){
            return null;
        }
        int maxLength = 0;
        String result = "";
        int len = str.length();
        int [][]dp = new int[len][len];
        for(int i = 1; i< len ; i++){
            for(int j = 0; j< i; j++){
                if(str.charAt(i) == str.charAt(j) && (dp[i-1][j+1] == 1)|| i - j  <= 2){
                    dp[i][j] = 1;
                }
                //比较最大值
                if((i - j + 1) > maxLength && dp[i][j] ==1){
                    result = str.substring(j,i+1);
                    maxLength = i-j+1;
                }
            }
        }
        return result;
    }
}
