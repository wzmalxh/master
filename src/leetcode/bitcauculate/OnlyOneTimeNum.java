package leetcode.bitcauculate;

public class OnlyOneTimeNum {
    public static void main(String[] args) {
        int []num = {1,22,22,33,33,1, 99};
        int k = solution(num);
        System.out.println(k);
    }

    public static int solution(int []nums){
        int res = 0;

        for(int i=0 ;i < nums.length ; i++){
            res = res ^ nums[i];
        }
        return  res;
    }
}
