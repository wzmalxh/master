package leetcode.dynamicprogram;

public class LCS {
    public static String LCS (String str1, String str2) {
        // write code here
        int maxLenth = 0;//记录最长公共子串的长度
        //记录最长公共子串最后一个元素在字符串str1中的位置
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLastIndex = 0;
        int[][] dp = new int[len1+1][len2 + 1];
        for (int i = 1; i <= str1.length(); i++) {
            //注意这里是倒叙
            for (int j = 1; j <= str2.length(); j++) {
                //递推公式，两个字符相等的情况
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    //如果遇到了更长的子串，要更新，记录最长子串的长度，
                    //以及最长子串最后一个元素的位置
                    if (dp[i][j] > maxLenth) {
                        maxLenth = dp[i][j];
                        maxLastIndex = i-1;
                    }
                } else {
                    //递推公式，两个字符不相等的情况
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(maxLastIndex);
        System.out.println(maxLenth);
        return str1.substring(maxLastIndex - maxLenth + 1, maxLastIndex+1);
    }

    public static void main(String[] args) {
        System.out.println(LCS("22222","22222"));
    }
}
