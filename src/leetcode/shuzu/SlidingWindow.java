package leetcode.shuzu;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public static int[]  maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            // 保持deque的递减顺序，确保deque的头部是最大值
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {

                deque.pollLast();
            }
            deque.offerLast(i);

            // 移除不在窗口内的索引
            if (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 当窗口大小达到k时，记录窗口的最大值
            if (i >= k-1) {
                result[index++] = nums[deque.peekFirst()];
            }

        }

        return result;


    }


    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int []res = maxSlidingWindow(nums,k);
        for (int i=0 ; i< res.length; i++){
            System.out.print(res[i] +  " ");
        }
    }
}
