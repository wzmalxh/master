package leetcode.string;

public class CompareStringVerson {
    public static int solution(String str1, String str2){
        int i=0;
        int j=0;
        int left = str1.length();
        int right = str2.length();
        while(i < left || j < right){
            //记录每一个. 中间的两个版本大小的对比
            int num1 = 0;
            int num2 = 0;

            while(i < left && str1.charAt(i) != '.'){
                num1 = 10*num1 + (str1.charAt(i) - '0');
                i++;
            }
            //跳过空格
            i++;
            while(j < right && str2.charAt(j) != '.'){
                num2 = 10*num2 + (str2.charAt(j) - '0');
                j++;
            }
            j++;

            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return  -1;
            }else{
                continue;
            }
        }
        return 0;
    }


}
