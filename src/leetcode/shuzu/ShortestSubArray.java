package leetcode.shuzu;

public class ShortestSubArray {
    /**
     * 长度最小子数组
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int value = 0;
        while(right < nums.length){
            value += nums[right];
            while(value >= target){
                //移动左边指针
                minLength = Math.min(minLength, right - left + 1);
                value -= nums[left];
                left++;
            }
            //移动右边指针
            right ++;
        }
        if(minLength == Integer.MAX_VALUE){
            return  0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int []nums = {1,1,1,1,1};
        System.out.println(minSubArrayLen(target,nums));
    }
}
