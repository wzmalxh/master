package leetcode.shuzu;

public class IncreasingTripletDemo {
    public static boolean increasingTriplet(int[] nums) {
        if(nums == null) {
            return false;
        }
        int len = nums.length;
        int []dp = new int[len+1];
        for(int j=0; j<= len; j++) {
            dp[j] = 1;
        }
        for(int k = 1; k< len; k++){
            for(int m= k-1; m >= 0; m--) {
                if(nums[m] < nums[k]) {
                    dp[k+1] = Math.max(dp[m+1] + 1, dp[k+1]);
                }
            }
        }
        for(int i=0; i<= len; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();
        for(int i=0; i<= len; i++) {
            if(dp[i] >= 3) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = {20,100,10,12,5,13};
        System.out.println(increasingTriplet(nums));
    }
}
