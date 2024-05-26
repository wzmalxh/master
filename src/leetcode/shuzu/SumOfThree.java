package leetcode.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {
    /**
     * 三数之和问题
     */
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        //第一趟遍历
        for (int first = 0; first < n; first++) {
            //前面至少有一个处理过的元素，避免与前面一个元素相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            //开始双指针遍历
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                //前面至少有一个元素处理过了，要避免重复处理
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                //双指针指向的和大于目标值的话，就将third指针往左移动
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                //没有找到合适的
                if (second == third) {
                    break;
                }
                //找到了合适的
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    //不能忘记添加到返回的链表中
                    ans.add(list);
                }
            }
        }
        return ans;
    }

}
