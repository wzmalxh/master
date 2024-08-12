package leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {
    /**
     * 题解：为了取到最后一个元素，string数组必须遍历到最后一个元素 <= s.length
     * 由于j是从0开始的，即使上一轮有匹配错的，依然可以重新发起匹配
     * 最终返回dp[s.legnth()] 为结果
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean []dp = new boolean[s.length()+1];
        dp[0] = true;
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for(int i = 1; i<= s.length(); i++){
            for(int j=0; j< i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leetc");
        wordDict.add("ode");
        wordDict.add("odes");
        wordDict.add("tring");
        System.out.println(wordBreak("leetcodestring",wordDict));
    }
}
