package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class AllCombineGroup {
    public static void main(String[] args) {
        AllCombineGroup grou = new AllCombineGroup();
        List<List<Integer>> result = new ArrayList<>();
        int []nums = {2,3,7,6};
        result = grou.combinationSum(nums,7);
        for(int i=0; i< result.size(); i++){
            for(int k = 0; k < result.get(i).size(); k++){
                System.out.print(result.get(i).get(k) + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //定义结果集
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, target, new ArrayList<>(), res,0);
        return res;
    }

    public void dfs(int []nums, int target, List<Integer> arrayList, List<List<Integer>> res, int idx){
        if(target == 0 && !arrayList.isEmpty()){
            res.add(new ArrayList<>(arrayList));
            return;
        }
        if(idx == nums.length){
            return;
        }
        for(int i= idx; i< nums.length; i++){
            if(target > 0){
                arrayList.add(nums[i]);
                dfs(nums, target - nums[i], arrayList, res, i);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

}
