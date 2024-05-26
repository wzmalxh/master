package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class ZPrintString {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        char[] stringChar = s.toCharArray();
        List<StringBuffer> list = new ArrayList<StringBuffer>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer());
        }
        int i = 0;
        int flag = -1;
        for (char c : stringChar) {
            list.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i = i + flag;
        }
        StringBuffer newStr = new StringBuffer();
        for (StringBuffer str : list) {
            newStr.append(str);
        }
        return newStr.toString();
    }

    public static void main(String args[]) {
        String s = "PAYPALISHIRING";
        ZPrintString solution = new ZPrintString();
        String newStr = solution.convert(s, 4);
        System.out.println(newStr);
    }

}
