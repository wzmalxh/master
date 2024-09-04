package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class IpAddressConvert {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    public static ArrayList<String> restoreIpAddresses(String s) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(String s, int index, List<String> tmp, List<String> result) {
        if (tmp.size() > 4) {
            return;
        }
        if (tmp.size() == 4 && index == s.length()) {
            result.add(construct(tmp));
        }
        for (int i = index + 1; i <= index + 3 && i <= s.length(); i++) {
            String str = s.substring(index, i);
            int value = Integer.parseInt(str);
            //需要排除 01 这种情况
            if(str.length() > 1 && str.charAt(0) == '0'){
                break;
            }
            if(value >= 0 && value <= 255) {
                tmp.add(str);
                dfs(s, i, tmp, result);
                tmp.remove(tmp.get(tmp.size()-1));
            }

        }
    }

    public static String construct(List<String> t) {
        StringBuilder sb = new StringBuilder();
        sb.append(t.get(0));
        for (int i=1; i< t.size(); i++){
            sb.append(".");
            sb.append(t.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "010010";
        ArrayList<String> result = restoreIpAddresses(s);
        for(int i=0; i< result.size(); i++){
            System.out.println(result.get(i));
        }

    }

}



