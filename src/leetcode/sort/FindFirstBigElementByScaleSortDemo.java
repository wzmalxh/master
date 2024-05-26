package leetcode.sort;

public class FindFirstBigElementByScaleSortDemo {
    public static void insertSort(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int j = i -1;
            int temp = nums[i];
            //如果找到递减的顺序的元素，循环交换
            while (j >= 0 && temp < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = temp;
        }
    }

    public static int findIndexK(int []nums, int target){
        insertSort(nums);
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i]+" ");
        }
        for(int i=0; i< nums.length; i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,2,5,3,6,8,9,11,1};
        int result = findIndexK(nums, 5);
        System.out.println("index is:"+ result);
    }
}