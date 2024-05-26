package leetcode.huisu;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IpAddressSplit {
    public static List<String> ipAddressSplit(String str){
        /**
         * 如果队列是空，直接返回
         */
        if (str == null || str.length() ==0) {
            return Collections.emptyList();
        }
        int len = 0;
        List<String> result = new ArrayList<>();
       dfs(new ArrayList<>(),len, str,result);
       return result;
    }

    //加入到结果集的函数需要满足两个条件： 1. 结果集大小等于4 2. 长度计量len 等于字符串长度 （没有多余的字符）
    private static void dfs(List<String> resultIp, int len, String str, List<String> result) {
        if (resultIp.size() > 4) {
            return;
        }
        if( resultIp.size() == 4 && len == str.length()){
            result.add(constructIp(resultIp));
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

    private static String constructIp(List<String> resultIp) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resultIp.get(0));
        for(int k=1 ; k< resultIp.size(); k++){
            stringBuilder.append(".").append(resultIp.get(k));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String adr = "0000";
        List<String> res = ipAddressSplit(adr);
        for(int i=0; i< res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
