package leetcode.shuzu;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TemperatureDemo {
    /**
     * 求出下一个最大元素的下标并返回
     */

    public static void main(String[] args) {
        int[] arr = {73,74,75,71,69,72,76,73};
        Set<Integer> st = new HashSet<>();
        st.add(5);
        st.add(6);
        st.add(8);
        for(Integer s: st) {
            System.out.println(s);
        }
        TemperatureDemo d = new TemperatureDemo();
        int []res = d.highTemperatureDate(arr);
        for(int i=0; i< res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
    public int[] highTemperatureDate(int []nums){
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int n = nums.length;
        int []res = new int[n];
        for(int i= 1; i< n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return  res;
    }
}
