package leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreakDemo {
    /**
     * 单词拆分
     */
    public static boolean wordBreak(String word , List<String> words){

        HashSet<String> wordSet = new HashSet<>(words);
        boolean []dp = new boolean[word.length()+1];
        dp[0] = true;
        for(int i= 1; i<= word.length(); i++){
            for(int j= 0 ; j< i; j++){
                if(wordSet.contains(word.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }


    public static void main(String[] args) {
        String word = "wpsd";
        List<String> w = new ArrayList<>(Arrays.asList("wp","s"));

        System.out.println(wordBreak(word,w));
    }
}
