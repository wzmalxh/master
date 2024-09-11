package leetcode.shuzu;

import java.util.*;

public class SumOfThree {
    /**
     * 三数之和问题
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j= i+1;
            int tmpSum = count - nums[i];
            int begin = j;
            int end = nums.length -1;
            List<Integer> tmpList = new ArrayList<>();
            while(begin < end) {
                if(nums[begin] + nums[end] < tmpSum) {
                    begin++;
                }else if(nums[begin] + nums[end] > tmpSum){
                    end--;
                }else{
                    tmpList.add(nums[begin]);
                    tmpList.add(nums[end]);
                    tmpList.add(nums[i]);
                    res.add(tmpList);
                    while (begin<end && nums[begin] == nums[begin+1]){
                        begin +=1;
                    }
                    while(begin < end && nums[end] == nums[end -1]) {
                        end -=1 ;
                    }
                    begin +=1;
                    end -= 1;
                    tmpList= new ArrayList<>();
                }
            }
        }
        return res;
    }


    /**
     * 自己实现的三数之和
     */

    public static List<List<Integer>> threeSumMyself(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        Arrays.sort(nums);
        for(int i=0; i< nums.length-2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j= i+1;
            int tmpSum = count - nums[i];
            int begin = j;
            int end = nums.length -1;
            List<Integer> tmpList = new ArrayList<>();
            while(begin < end) {
                if(nums[begin] + nums[end] < tmpSum) {
                    begin++;
                }else if(nums[begin] + nums[end] > tmpSum){
                    end--;
                }else{
                    tmpList.add(nums[begin]);
                    tmpList.add(nums[end]);
                    tmpList.add(nums[i]);
                    if(!containsValid(tmpList,res)){
                        res.add(tmpList);
                    }


                    tmpList= new ArrayList<>();
                    begin += 1;
                    end -= 1;

                }
            }
        }
        return res;
    }

    private static boolean containsValid(List<Integer> tmpList, List<List<Integer>> res) {
        for(int i=0; i< res.size(); i++){
            List<Integer> resTmp = res.get(i);
            Set<?> set1 = new HashSet<>(resTmp);
            Set<?> set2 = new HashSet<>(tmpList);

            // 比较两个Set是否相等
            if(set1.equals(set2)){
                return  true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int []nums = {0,0,-2,-2,2};
        List<List<Integer>> result = threeSumMyself(nums);
        for(int i=0; i< result.size(); i++){
            for(int j=0; j< result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j)+ " ") ;
            }
            System.out.println();
        }
    }

}
