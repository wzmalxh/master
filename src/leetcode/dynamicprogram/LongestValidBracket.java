package leetcode.dynamicprogram;

import java.util.Stack;

public class LongestValidBracket {
    public static int maxLengthBracketValid(String str) {
        int maxLength = 0;
        Stack<Integer> st = new Stack<>();
        //字符串中char的下标存入栈
        st.push(-1);
        for(int i=0 ; i< str.length(); i++){
            if(str.charAt(i) == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    // 计算当前有效括号的长度，即当前右括号索引减去栈顶左括号索引
                    maxLength = Math.max(maxLength, i-st.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "()()(())()()";
        System.out.println(maxLengthBracketValid(str));
    }
}
