package leetcode.string;

import java.util.Stack;

public class EvalRPNDemo {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String s: tokens) {
            if(!"+".equals(s) && !"-".equals(s) && !"*".equals(s) && !"/".equals(s)) {
                //说明是数字
                int value = Integer.parseInt(s);
                st.push(value);
            } else {
                if (st.size() >= 2) {
                    int left = st.pop();
                    int right = st.pop();
                    switch (s) {
                        case "+":
                            left =  right + left;
                            break;
                        case "-":
                            left = right - left;
                            break;
                        case "*":
                            left = left * right;
                            break;
                        case "/":
                            left = right / left;
                            break;
                    }
                    st.push(left);
                }
            }
        }
        if(!st.isEmpty()) {
            return st.pop();
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String []str = {"4","13","5","/","+"};
        int value = evalRPN(str);
        System.out.println(value);
    }
}
