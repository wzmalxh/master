package leetcode.dynamicprogram;

public class LongestCommonSubArrayPrintSubArray {
    /**
     * 最长公共子序列，需要打印出来最长的子序列的题目
     */
    /**
     * longest common subsequence
     *
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String s1, String s2) {
        // write code here
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        if (dp[n][m] == 0)
            return "-1";
        StringBuilder sb = new StringBuilder();
        while (n > 0 && m > 0) {
            if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
                sb.append(s1.charAt(n - 1));
                n--;
                m--;
            } else {
                if (dp[n - 1][m] > dp[n][m - 1]) {
                    n--;
                } else {
                    m--;
                }
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23A456A";
        System.out.println(LCS(str1, str2));
    }
}
