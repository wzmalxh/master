package leetcode.shuzu;

public class FindPeakDemo {
    /**
     * leetcode 寻找峰值 二分查找
     */
    public int findPeakElement (int[] nums) {
        // write code here
        if(nums == null || nums.length ==0){
            return 0;
        }
        int l = 0;
        int r = nums.length;
        while(l < r){
            int  mid = (l+r)/2 ;
            if(nums[mid] < nums[mid+1]){
                l = mid +1;
            }else{
                r = mid ;
            }
        }
        return r;
    }
}
