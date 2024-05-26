package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class BracketCreate {
    /**
     * 括号生成
     */
    public static List<String> solution(int n){
        List<String> result = new ArrayList<>();
        int left = n;
        int right = n;

        dfsBracket(n,left, right,"(", result);
        return result;
    }

    private static void dfsBracket(int n, int l, int r, String str, List<String> result) {
        if (l ==0 && r ==0){
            result.add(str);
            return;
        }
        if (l < 0 || r < 0 || l > n || r > n || l > r){
            return;
        }
        //左括号小于右括号，增加右括号
        if (l < r ) {
            dfsBracket(n, l, r-1, str+")", result);
        }
        if (l > 0) {
            dfsBracket(n, l-1, r, str+"(", result);
        }
    }

    public static void main(String[] args) {
        int n= 3;
        List<String> res = solution(n);
        for(String str:res){
            System.out.println(str);
        }
    }
}
