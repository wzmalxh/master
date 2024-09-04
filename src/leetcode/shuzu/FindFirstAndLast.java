package leetcode.shuzu;

public class FindFirstAndLast {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        int []res = new int[2];
        res[0] = findFirst(nums,target);
        res[1] = findLast(nums,target);
        return res;
    }

    private int findFirst(int[] nums, int target) {
        int s = 0;
        int e = nums.length -1;
        while(s < e){
            int mid = (s + e)/2;
            if(nums[mid] < target){
                s = mid +1;
            }else if(nums[mid] > target) {
                e = mid -1;
            }else{
                while (mid >= 1 && nums[mid] == nums[mid-1]){
                    mid = mid -1;
                }
                return mid;
            }
        }
        return -1;
    }


    private int findLast(int[] nums, int target) {
        int s = 0;
        int e = nums.length -1;
        while(s < e){
            int mid = (s + e)/2;
            if(nums[mid] < target){
                s = mid +1;
            }else if(nums[mid] > target) {
                e = mid -1;
            }else{
                while (mid < e && nums[mid] == nums[mid+1]){
                    mid = mid  + 1;
                }
                return mid;
            }
        }
        return -1;
    }
}
