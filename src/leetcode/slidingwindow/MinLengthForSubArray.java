package leetcode.slidingwindow;

public class MinLengthForSubArray {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续
     * 子数组
     * [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     */
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        //窗口起始点
        int i = 0;
        int minLength = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                minLength = Math.min(j - i + 1, minLength);
                sum = sum - nums[i];
                i++;

            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        MinLengthForSubArray minLengthForSubArray = new MinLengthForSubArray();
        int result = minLengthForSubArray.minSubArrayLen(7, arr);
        System.out.println(result);
    }
}
