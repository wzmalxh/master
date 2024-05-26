package leetcode.shuzu;

public class NextBigSequenceList {
    public static void main(String[] args) {
        int []num = {2,3,5,4,1};
        int []res = solution(num);
        for(int i=0; i< res.length; i++){
            System.out.print(num[i]+" ");
        }
    }

    public static int[] solution(int []nums){
        int length = nums.length;
        int k = length -1;
        while(k >0 && nums[k-1] > nums[k]) k--;
        if(k <= 0){
           nums =  reverseNum(nums);
        }
        //找到第一个需要交换的元素，需要在k到nums.length -1中找比它大的元素
        int  t = nums.length -1 ;

        while(t >0 && nums[t-1] < nums[k-1]){
            t--;
        }
        t-=1;
        swapNumber(nums,k-1,t);

        //k到你length-1的转换为升序
        int start = k, end = nums.length - 1;
        while (start < end ) {
            int reTemp = nums[start];
            nums[start] = nums[end];
            nums[end] = reTemp;
            start++;
            end--;
        }
        return nums;
    }

    private static int [] reverseNum(int[] nums) {
        int []res = new int[nums.length];
        int cnt =0;
        for(int i =nums.length-1; i > 0; i--){
            res[cnt++] = nums[i];
        }
        return res;
    }

    private static void swapNumber(int[] nums, int i, int t) {
        int tmp = nums[i];
        nums[i] = nums[t];
        nums[t] = tmp;
    }
}
