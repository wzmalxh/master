package leetcode.shuzu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SumOfThreeMyself {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        while(count < nums.length -2){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[count]);
            int sum = 0 - nums[count];
            Map<Integer, Integer> map = new HashMap<>();
            for(int k= count+1; k< nums.length -1; k++){
                if(!map.containsKey(sum-nums[k])){
                    map.put(sum - nums[k], nums[k]);
                }else{
                    tmp.add(map.get(sum - nums[k]));
                    tmp.add(nums[k]);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                }
            }
        }
        return res;
    }
}
