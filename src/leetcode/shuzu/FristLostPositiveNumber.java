package leetcode.shuzu;

public class FristLostPositiveNumber {
    /**
     * 缺失的第一个正整数
     */
    public static int solution(int []num){
        int n = num.length;
        for(int i=0; i< num.length ; i++){
            if(num[i] > 0 && num[i] <= n && num[i] != num[num[i]-1]){
                swapNum(num, i, num[i]-1);
            }
        }
        for(int i=0; i< n; i++){
            if(i+1 != num[i]){
                return i+1;
            }
        }
        return  n+1;
    }

    private static void swapNum(int[] num, int i, int i1) {
        int tmp = num[i];
        num[i] = num[i1] ;
        num[i1] = tmp;
    }

    public static void main(String[] args) {
        int []num = {1,-1,3,4};
        System.out.println(solution(num));
    }
}
