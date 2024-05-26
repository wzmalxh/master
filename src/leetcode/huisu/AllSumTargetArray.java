package leetcode.huisu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class AllSumTargetArray {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //定义结果集
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), res,0);
        return res;
    }

    public void dfs(int[] nums, int target, List<Integer> arrayList, List<List<Integer>> res, int index) {
        if(index == nums.length){
            return;
        }
        if (target == 0 && !arrayList.isEmpty()) {
            res.add(new ArrayList<>(arrayList));
            return;
        }
        dfs(nums, target, arrayList, res, index + 1);
        if (target >= nums[index]) {
            arrayList.add(nums[index]);
            dfs(nums, target - nums[index], arrayList, res, index);
            arrayList.remove(arrayList.size() - 1);

        }
    }


    public static void main(String[] args) {
        AllSumTargetArray allSumTargetArray = new AllSumTargetArray();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = allSumTargetArray.combinationSum(nums, target);

        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}