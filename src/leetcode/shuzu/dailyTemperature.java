package leetcode.shuzu;

public class dailyTemperature {
    public static int[] dailyTemperatures(int[] temperatures) {
        int []dp = new int[temperatures.length];
        int len = temperatures.length;
        int []res = new int[temperatures.length];
        for(int i=0 ; i < res.length-1; i++) {
            res[i] = Integer.MAX_VALUE;
        }
        res[len -1] = 0;
        for(int i= len-1; i >= 0 ; i--) {
            for(int j= 0; j<= i; j++) {
                if(temperatures[j] < temperatures[i] && res[j] > (i-j)) {
                    res[j] = i - j;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []temp = {73,74,75,71,69,72,76,73};
        int []res = dailyTemperatures(temp);
        for(int i=0; i< res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
