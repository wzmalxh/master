package leetcode.slidingwindow;

public class MinLengthForSubArrayBaoli {

    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int i =0 ;i< nums.length; i++){
            for(int j=0; j< i; j++){
                sum += nums[j];
                if(sum >= target){
                    minLength = Math.min(i-j +1, minLength);
                }
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        MinLengthForSubArrayBaoli minLengthForSubArray = new MinLengthForSubArrayBaoli();
        int result = minLengthForSubArray.minSubArrayLen(7, arr);
        System.out.println(result);
    }
}
