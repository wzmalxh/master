package leetcode.math;

public class MyPow {
    public static double myPow(double x, int n) {
        double res = 0;
        if(n == 0){
            res = 1;
            return res;
        }else if(n > 0){
            int cnt =1;
            double tmp = x;
            while(cnt < n){
                tmp = tmp * x;
                cnt++;
            }
            res = tmp;
        }else{
            int cnt =1;
            double bb = 1;
            double  tmp=  x;
            while(cnt < Math.abs(n)){
                tmp = tmp * x;
                cnt++;
            }
            res = bb/tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        double x = 2;
        int n= -2;
        System.out.println(myPow(x,n));
    }
}
