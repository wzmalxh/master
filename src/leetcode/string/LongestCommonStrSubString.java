package leetcode.string;

public class LongestCommonStrSubString {

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int maxLength = 0;
        int minStrLength = Integer.MAX_VALUE;
        String result = "";
        String minStrSub = "";
        for(int i=0; i< strs.length; i++) {
            if(strs[i].length() < minStrLength) {
                minStrLength = strs[i].length();
                minStrSub = strs[i];
            }
        }
        int flag = 0;
        for(int i=0; i< minStrLength; i++){
            for(int j=i+1; j < minStrLength; j++) {
                int cnt =0;
                String tmp = minStrSub.substring(i,j+1);
                if(flag == -1){
                    flag = 0;
                    break;
                }
                for(int k =0;k < strs.length; k++) {
                    if(!strs[k].contains(tmp)) {
                        flag =-1;
                        break;
                    }else{
                        cnt ++;
                    }
                    if(cnt == strs.length && tmp.length() > maxLength) {
                        maxLength = tmp.length();
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String [] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
