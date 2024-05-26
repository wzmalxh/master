package leetcode.string;

import java.util.Stack;

public class RevertStringDemo {
    public static void main(String[] args) {
        String str = "the sky";
        System.out.println(revert(str));
    }

    public static String revert(String str) {
        StringBuilder res = new StringBuilder();
        if (str == null) {
            return res.toString();
        }
        Stack<String> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder tmp = new StringBuilder();
            while (i< str.length() && (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
                    || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                tmp.append(str.charAt(i));
                if(i < str.length() -1) {
                    i++;
                }else {
                    break;
                }
            }
            st.push(tmp.toString());
            if(i < str.length() - 1){
                st.push(" ");
            }
        }

        while (!st.isEmpty()){
            res.append(st.peek());
            st.pop();
        }
        return res.toString();
    }
}
