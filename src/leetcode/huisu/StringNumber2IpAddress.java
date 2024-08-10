package leetcode.huisu;


import java.util.ArrayList;
import java.util.List;

public class StringNumber2IpAddress {

    public static void main(String[] args) {
        String str = "25525522135";
        ArrayList<String> res = restoreIpAddresses(str);
        System.out.println(res);
    }
    public static ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void dfs(String s, int index, List<String> tmp, List<String> result) {
        if(tmp.size() == 4 && index == s.length()){
            result.add(constructResult(tmp));
        }
        for(int i= index +1; i<= index +3 && i <= s.length(); i++){
            String sTemp = s.substring(index,i);
            int value = Integer.parseInt(sTemp);
            if(sTemp.length() > 1 && sTemp.charAt(0) == '0') {
                //剔除所有023这种数据
                break;
            }
            if(value >=0 && value <= 255){
                tmp.add(sTemp);
                dfs(s,i, tmp, result);
                tmp.remove(tmp.size() -1);
            }
        }
    }


    private static String constructResult(List<String> tmp){
        StringBuilder sb = new StringBuilder();
        sb.append(tmp.get(0));
        for(int i=1; i< tmp.size(); i++){
            sb.append(".");
            sb.append(tmp.get(i));
        }
        return sb.toString();
    }
}
