package leetcode.shuzu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSumMyself {
    public static void main(String[] args) {
        int []nums = {0,0,0};
        List<List<Integer>> res = threeSum(nums);
        for(int i=0;i < res.size() ; i++){
            for(int j=0 ; j< res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        while(count < nums.length -2){
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[count]);
            int sum = 0 - nums[count];
            Map<Integer, Integer> map = new HashMap<>();
            for(int k= count+1; k< nums.length -1; k++){
                if(!map.containsKey(nums[k])){
                    map.put(sum - nums[k], k);
                }else{
                    tmp.add(nums[map.get(nums[k])]);
                    tmp.add(nums[k]);
                    res.add(tmp);
                    tmp = new ArrayList<>();
                    map = new HashMap<>();
                    tmp.add(nums[count]);
                }
            }

            count ++;
        }
        return res;
    }
}
