package leetcode.string;

import java.util.Stack;

public class DecodeString394 {

    public static String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        int index = 0;
        int length = s.length();
        while (index < length) {
            if (s.charAt(index) != ']') {
                st.push(s.charAt(index));
            } else {
                StringBuilder sb = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    while (st.peek() >= 'a' && st.peek() <= 'z') {
                        char ch = st.peek();
                        st.pop();
                        sb.append(ch);
                    }
                }
                if (!st.isEmpty()) {
                    st.pop();
                    sb.reverse();
                    StringBuilder sCount = new StringBuilder();
                    while (!st.isEmpty() && st.peek() >= '0' && st.peek() <= '9') {
                        sCount.append(st.peek());
                        st.pop();
                    }
                    int loop = 0;
                    if (!sCount.toString().isEmpty()) {
                        sCount.reverse();
                        loop = Integer.parseInt(sCount.toString());
                    }

                    for (int i = 0; i < loop; i++) {
                        for (int k = 0; k < sb.toString().length(); k++) {
                            st.push(sb.toString().charAt(k));
                        }
                    }
                }
                //说明是 ‘【’
            }
            index++;
        }

        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        String str = "3[a2[c]]";
        System.out.println(decodeString(str));
    }
}
