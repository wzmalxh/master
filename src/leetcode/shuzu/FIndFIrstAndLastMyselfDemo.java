package leetcode.shuzu;

import sun.security.x509.GeneralName;

public class FIndFIrstAndLastMyselfDemo {
    public int[] searchRange(int[] nums, int target) {
        int begin = findFirst(nums,target,0, nums.length-1);
        int end = findLast(nums,target, 0 ,nums.length-1);
        int []res = new int[2];
        res[0] = begin;
        res[1] = end;
        return res;
    }

    public int findFirst(int []nums, int target , int begin ,int end){
        while(begin <= end){
            int mid = (begin + end)/2;
            if(nums[mid] < target){
                begin = mid+1 ;
            }else if(nums[mid] == target){
                while(mid > 0 && nums[mid-1] == nums[mid]){
                    mid--;
                }
                return mid;
            }else{
                end = mid -1;
            }
        }
        return -1;
    }

    public int findLast(int []nums, int target , int begin ,int end){
        while(begin <= end){
            int mid = (begin + end)/2;
            if(nums[mid] < target){
                begin = mid+1;
            }else if(nums[mid] == target){
                while(mid <= end-1 && nums[mid+1] == nums[mid]){
                    mid++;
                }
                return mid;
            }else{
                end =mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FIndFIrstAndLastMyselfDemo demo = new FIndFIrstAndLastMyselfDemo();
        int []nums = {2,2};
        int target = 2;
        int []res = demo.searchRange(nums,target);
        for(int i=0; i< res.length; i++){
            System.out.print (res[i]+" ");
        }
    }
}
