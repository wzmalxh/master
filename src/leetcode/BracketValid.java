package leetcode;

import java.util.Stack;

public class BracketValid {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int len = s.length();
        int i = 0;
        while (i < len ){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if(st.isEmpty()){
                    return false;
                }
                if (s.charAt(i) == ')' && st.peek() != '(') {
                    return false;
                } else if (s.charAt(i) == '}' && st.peek() != '{') {
                    return false;
                } else if (s.charAt(i) == ']' && st.peek() != '[') {
                    return false;
                } else {
                    st.pop();
                }
            }
            i ++;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "[";
        System.out.println(isValid(str));
    }
}
