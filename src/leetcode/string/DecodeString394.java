package leetcode.string;

import java.util.Stack;

public class DecodeString394 {

    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        String result ="";
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) != ']'){
                st.push(s.charAt(i));
            }else{
                StringBuilder sb = new StringBuilder();
                while(st.size() > 0){
                    char ch = st.peek();
                    st.pop();
                    if(ch >= '1' && ch <= '9'){
                        int loop = ch - '0';
                        for(int k=0; k< loop; k++){
                            sb = sb.append(sb);
                        }
                    }else if(ch >= 'a' && ch <= 'z'){
                        sb.append(ch);
                    }else {
                        if(st.size() > 0){
                            result = sb.toString();
                            char[] cArray = result.toCharArray();
                            for (char c : cArray) {
                                st.push(c);
                            }
                        }else{
                            return result;
                        }
                    }


                }
            }
        }
        return "";
    }


    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str));
    }
}
