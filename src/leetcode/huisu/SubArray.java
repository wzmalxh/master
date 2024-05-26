package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class SubArray {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(0, nums,res,new ArrayList<Integer>());
        return res;
    }

    private static void dfs(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            dfs(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int []arr = {1,2,3,4};
        System.out.println(subsets(arr));
    }
}
