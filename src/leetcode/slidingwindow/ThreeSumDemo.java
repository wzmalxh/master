package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumDemo {
    public List<List<Integer>> threeSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-1 ; i++){
            List<Integer> tmp = new ArrayList<>();
            int left = i +1;
            int right = nums.length -1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] < target){
                    left ++;
                }else if(nums[i] + nums[left] + nums[right] > target){
                    right--;
                }else{
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    result.add(tmp);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumDemo sumDemo = new ThreeSumDemo();
        int []nums  ={-1,0,1,2,-1,-4};
        List<List<Integer>> result = sumDemo.threeSum(nums,0);
        for(int i=0; i< result.size(); i++){
            for (int j = 0; j< result.get(i).size(); j++){
                System.out.print(result.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
