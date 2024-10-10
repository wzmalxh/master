package leetcode.shuzu;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int len = nums.length - 1;
        int cnt = 0;
        int start = 0 ;
        int end = len;
        while(start <= len) {
            if(nums[start] == val) {
                while (end > 0 && nums[end] == val) {
                    end -=1;
                }
                if (end > start) {
                    swapValue(nums,start,end);
                    start ++;
                } else {
                    return start-1;
                }
            } else {
                start ++;
            }


        }
        return cnt;
    }

    public static void swapValue(int []num, int s, int e) {
        int temp;
        temp = num[e];
        num[e] = num[s];
        num[s] = temp;
    }

    public static void main(String[] args) {
        int []nums = {3,2,2,3};
        int k = 3;
        System.out.println(removeElement(nums,k));
    }
}
