package leetcode.sort;

public class ColorArrangeSort {
    public static void sortColors(int[] nums) {
        int i=0;
        int j = nums.length-1;
        quickSort(nums,i,j);
    }

    public static void quickSort(int []nums, int start, int end) {
        if(start >= end || start < 0 || end >= nums.length) {
            return;
        }
        int i = start+1;
        int j= end;
        int pibot = nums[start];
        while(i < j) {
            while(nums[j] >= pibot && i < j) {
                j --;
            }
            while (nums[i] <= pibot && i < j) {
                i ++;
            }
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        nums[i] = pibot;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }

    public static void main(String[] args) {
        int []nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i=0; i< nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
