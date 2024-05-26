package leetcode.shuzu;

public class FindFirstAndLastNumberTarget {
    public static void main(String[] args) {
        int []nums = {5,7,7,8,8,10};
        int target = 8;
        int []res = findFirstAndLast(nums,target);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] findFirstAndLast(int []nums, int target){
        int left = findFirstValue(nums, target);

        int right = findLastValue(nums,target);

        return new int[]{left,right};
    }

    private static int findFirstValue(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] != target){
                    return mid;
                }else{
                    right = mid -1;
                }
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return  -1;
    }

    private static int findLastValue(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] != target){
                    return mid;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return -1;
    }
}
