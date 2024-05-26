package leetcode.huisu;

import java.util.*;

public class LetterCombine {
    /**
     * 电话号码的所有生成的可能
     */


    public static List<String> letterCombination(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;

    }

    public static void dfs(List<String> res,Map<Character,String> map, String digit,int length, StringBuffer characters) {
        if(length == digit.length()){
            res.add(characters.toString());
        } else{
            //否则先查询第一个元素
            String letters = map.get(digit.charAt(length));
            System.out.println("Str is:"+ letters);
            for(int i=0 ; i< letters.length(); i++){
                characters.append(letters.charAt(i));
                dfs(res,map,digit,length+1,characters);
                //删除本轮添加的第一个元素
                characters.deleteCharAt(characters.length()-1);
            }
        }

    }

    public static void main(String[] args) {
        String str = "23";
        List<String> res = letterCombination(str);
        for(String r:res){
            System.out.println(r);
        }
    }
}
