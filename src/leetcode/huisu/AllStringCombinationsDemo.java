package leetcode.huisu;

import java.util.*;
import java.util.stream.Collectors;

public class AllStringCombinationsDemo {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('b');
        characters.add('c');
        List<List<Character>> result = AllCombinations(characters);
        for (List<Character> r : result) {
            System.out.println(r);
        }
    }
    public static List<List<Character>> AllCombinations(List<Character> characters) {
        List<List<Character>> result = new ArrayList<>();
        //结果候选
        List<Character> tmp = new ArrayList<>();
        dfs(characters, 0, tmp, result);
        return result;
    }

    private static void dfs(List<Character> characters, int index, List<Character> res, List<List<Character>> result) {
        if (index == characters.size()) {
            List<Character> list = new ArrayList<>(res);
            if (!result.contains(list)) {
                result.add(list);
            }
            return;
        }
        for (int k = index; k < characters.size(); k++) {
            dfs(characters, index + 1, res, result);
            res.add(characters.get(index));
            dfs(characters, index + 1, res, result);
            //减支回到上一步
            res.remove(res.get(res.size() - 1));
        }
    }
}
