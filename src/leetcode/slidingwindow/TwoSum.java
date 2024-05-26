package leetcode.slidingwindow;

import java.util.HashMap;
import java.util.List;

public class TwoSum {
    /**
     * 两数之和问题
     */
    public int[] twoSum(int target, int []nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i= 0; i< nums.length ; i++){
            if(!map.containsKey(target-nums[i])){
                map.put(target - nums[i], i);
            }else{
                return  new int[]{target-nums[i], nums[i]};
            }
        }
        return  new int[2];
    }

    public static void main(String[] args) {
        int []arr = {2,7,11,15};
        int target = 9;
        TwoSum t = new TwoSum();
        int []res = t.twoSum(target,arr);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }
}
