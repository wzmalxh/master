package leetcode.shuzu;

import java.util.function.Supplier;

public class NextBigSequenceList {
    public static void main(String[] args) {
        int []num = {1,5,1};
        int []res = solution(num);
        for(int i=0; i< res.length; i++){
            System.out.print(num[i]+" ");
        }
    }

    public static int[] solution(int []nums){
        int length = nums.length;
        int k = length -1;
        while(k > 0 && nums[k-1] > nums[k])
            k--;
        if(k < 0){
           nums =  reverseNum(nums,0,nums.length-1);
        }
        //找到第一个需要交换的元素，需要在k到nums.length -1中找比它大的元素
        int  t = nums.length -1 ;

        while(t > 0 && k > 0  && nums[t] < nums[k-1]){
            t--;
        }
        int tmp = nums[k-1];
        nums[k-1] = nums[t];
        nums[t] = tmp;
        //k到length-1的转换为升序
        int start = k;
        int end = nums.length - 1;
        while (start < end ) {
            int reTemp = nums[start];
            nums[start] = nums[end];
            nums[end] = reTemp;
            start++;
            end--;
        }
        return nums;
    }

    private static int [] reverseNum(int[] nums, int start, int end) {
        while (start < end ) {
            int reTemp = nums[start];
            nums[start] = nums[end];
            nums[end] = reTemp;
            start++;
            end--;
        }
        return nums;
    }

}
