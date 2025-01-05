package leetcode.huisu;

import java.util.ArrayList;
import java.util.List;

public class IpAddressSplitD {
    public static String[] restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfsIpAddress(0,s,result,new ArrayList<>());
        //dfs(result,0,s,new ArrayList<>());
        return  result.toArray(new String[0]);
    }

    public static void dfsIpAddress(int index, String str, List<String> result, List<String> tmp) {
        if(tmp.size() > 4) {
            return;
        }
        if(tmp.size() == 4 && index == str.length()) {
            String resTmp = convertToResult(tmp);
            result.add(resTmp);
        }
        for(int i= index+1; i<= index+3 && i <= str.length(); i++) {
            //截取字符串，转换为数字判断，合适则进入递归
            String t = str.substring(index, i);
            int value = Integer.parseInt(t);
            if (t.length() > 1 && t.charAt(0) == '0') {
                //排除 01，02的这种情况
                break;
            }
            if(value >=0 && value <= 255) {
                tmp.add(t);
                dfsIpAddress(i, str,result,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }


    private static void dfs(List<String> resultIp, int len, String str, List<String> result) {
        if (resultIp.size() > 4) {
            return;
        }
        if( resultIp.size() == 4 && len == str.length()){
            result.add(convertToResult(resultIp));
        }
        //如果小于4，开始回溯
        for (int i=len+1; i<= str.length() && i <= len + 3; i++) {
            String strTemp = str.substring(len, i);
            int value  = Integer.parseInt(strTemp);
            if (strTemp.length() > 1 && strTemp.charAt(0) == '0') {
                break;
            }
            //如果处于0 -255之间，则继续修改len为i的标识，继续递归
            if (value <= 255 && value >=0) {
                resultIp.add(strTemp);
                //从下一个位置i开始回溯
                dfs(resultIp, i, str, result);
                //回溯完当前这种情况，记得退后一步，e.g. 255.255.223.5 ---> 255.255.223.
                resultIp.remove(resultIp.size() -1);
            }
        }
    }

    private static String convertToResult(List<String> tmp) {
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < tmp.size()-1; k++) {
            sb.append(tmp.get(k)).append(".");
        }
        sb.append(tmp.get(tmp.size()-1));
        return sb.toString();
    }



    public static void main(String[] args) {
        String adr = "25525511135";
        String[] res = restoreIpAddresses(adr);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }

}
