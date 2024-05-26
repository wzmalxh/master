package leetcode.shuzu;

public class BinarySearchDemo {
    public static int search (int[] nums, int target) {
        // write code here
        int start = 0;
        int end = nums.length-1;
        int k = binarySearch(nums, start ,end, target);
        return k;
    }

    public static int binarySearch(int []nums, int start ,int end , int target){
        if(start >= end && nums[start] != target){
            return -1;
        }
        int mid = (end + start )/2;
        if(nums[mid] == target) {
            return mid;
        }else if(nums[mid] > target){
            end = mid -1;
            return   binarySearch(nums,start,end,target);
        }else{
            start = mid +1;
            return   binarySearch(nums,start,end,target);
        }
    }

    public static void main(String[] args) {
        int []arr = {-1,0,3,4,6,10,13,14};
        int target = 13;
        System.out.println(search(arr,target));
    }
}
