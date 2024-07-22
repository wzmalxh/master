package leetcode.stack;

import java.util.Stack;

public class DecodeStringDemo {
    public static void main(String[] args) {
        String str = "3[a2[c]]";
        System.out.println(decodeString(str));
    }
    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                st.push(s.charAt(i));
            }else if(s.charAt(i) == ']'){
                while(!st.isEmpty() && st.peek() != '['){
                    char ch = st.peek();
                    st.pop();
                    int loop = -1;
                    if(ch >= '1' && ch <= '9'){
                         loop = (ch - '0') ;
                    }else{
                        if(loop > 0){
                            //说明有循环拼接
                            for(int k=0; k< loop; k++){
                                sb =sb.append(ch);
                            }
                        }else{
                            sb.append(ch);
                        }
                        loop = -1;
                    }
                }
                for(int m=0; m< sb.length(); m++){
                    st.push(sb.charAt(m));
                }
            }
        }
        return sb.toString();
    }
}
