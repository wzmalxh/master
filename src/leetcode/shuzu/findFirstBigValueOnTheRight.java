package leetcode.shuzu;

import java.util.Stack;

public class findFirstBigValueOnTheRight {
    public int[] findMaxRightWithStack(int[] array) {
        if (array == null) {
            return array;
        }

        int size = array.length;

        int[] result = new int[size];

        Stack<Integer> stack = new Stack<>();

        for(int index =0; index < size; index ++) {
            while (!stack.isEmpty() && array[index] > array[stack.peek()]) {
                int k = stack.pop();
                result[k] = array[index];
            }
            stack.push(index);

        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }


    public static void main(String[] args) {
        findFirstBigValueOnTheRight r = new findFirstBigValueOnTheRight();
        int []array = {2,6,3,8,10,9};
        int []res = r.findMaxRightWithStack(array);
        for(int i=0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

}
