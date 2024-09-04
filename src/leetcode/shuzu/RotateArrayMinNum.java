package leetcode.shuzu;

public class RotateArrayMinNum {
    public static int findMin(int[] nums) {
        int begin = 0;
        int end = nums.length -1 ;
        int mid = (begin+end)/2;
        while(begin <= end){
            if(nums[mid] > nums[begin] && nums[begin] > nums[end]) {
                //说明最小值可能在后半段
                if(mid + 1 < end) {
                    begin = mid ;
                    mid = (begin + end)/2;
                }else if(nums[mid] > nums[begin] && nums[begin] < nums[end]){
                    return nums[begin];
                }else {
                    return nums[mid];
                }
            }else if(nums[mid] < nums[begin] && nums[begin] > nums[end]){
                if(mid - 1 >= begin){
                    end = mid;
                    mid = (begin + end)/2;
                }else{
                    return nums[mid];
                }
            }
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int []srr = {3,4,5,1,2};
        System.out.println(findMin(srr));
    }
}
