package leetcode.string;

public class StringCompareDemo {
    public static int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        int index =0;
        int k = 0;
        while(k < haystack.length()){
            int i = k;
            if(haystack.charAt(i) == needle.charAt(index)){
                while(i < haystack.length() && index < needle.length()){
                    if(haystack.charAt(i) == needle.charAt(index)){
                        i++;
                        index++;
                    }else {
                        index = 0;
                        break;
                    }
                }
                if(index == needle.length()){
                    return k;
                }

            }
            k++;
        }
        return -1;
    }


    public static void main(String[] args) {
        String str1 = "aaaa";
        String str2 = "aaa";
        System.out.println(strStr(str1,str2));
    }
}
