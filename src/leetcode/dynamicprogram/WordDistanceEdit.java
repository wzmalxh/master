package leetcode.dynamicprogram;

public class WordDistanceEdit {
    public static int editDistance(String str1, String str2){
        int k =str1.length();
        int m = str2.length();
        str1 = " "+str1;
        str2 = " "+str2;
        int [][]dp = new int[k+1][m+1];
        for(int i=1; i<= k; i++) dp[i][0] = i;
        for(int j=1; j<= m; j++) dp[0][j] = j;
        int minDis = Integer.MAX_VALUE;
        for(int i= 1; i<= k ;i++){
            for(int j=1 ;j <=m ;j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    if(dp[i][j-1] < dp[i-1][j] && dp[i][j-1] < dp[i-1][j-1]){
                        dp[i][j] = dp[i][j-1] +1;
                    }else if(dp[i-1][j] < dp[i][j-1] && dp[i-1][j] < dp[i-1][j-1]){
                        dp[i][j] = dp[i-1][j] +1;
                    }else{
                        dp[i][j] = dp[i-1][j-1] +1;
                    }
                }
            }
        }
        if(dp[k][m] < minDis){
            minDis = dp[k][m];
        }
        return minDis;

    }

    public static void main(String[] args) {
        String str1 = "nowcoder";
        String str2 ="new";
        System.out.println(editDistance(str1,str2));
    }
}
