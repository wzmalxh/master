package leetcode.math;

public class RedPackageDivide {
    /**
     * 最小红包为m，最大红包为n，总共有sum的money，要分x个，每个不超过m和n的区间，写出函数给出一种分法
     */
    public static int[] splitRedPackage(int sum, int x, int m, int n) {
        if (sum / m  > x || sum/n < x) {
            //说明按照100分最大的红包都大于限制 或者 最小值都不满足x个红包
            return null;
        }
        if(x <= 2 && m+n != sum) {
            return null;
        }
        int []result = new int[x];
        result[0] = n;
        result[1] = m;
        int leaveValue = sum -m -n;
        int leafIndex = x-2;
        int averageValue = leaveValue / leafIndex;

        int modValue = leaveValue % leafIndex;
        for(int i= 2; i< x; i++) {
            result[i] = averageValue;
        }
        while(modValue > 0) {
            for(int i=2; i< result.length; i++) {
                if(result[i] >= n && result[i] < m) {
                    result[i] += 1;
                    modValue -= 1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int sum = 68;
        int x =6;
        int m= 24;
        int n= 8;
        int[] res = splitRedPackage(sum,x,m,n);
        for(int i=0; i< res.length; i++) {
            System.out.print(res[i]+ " ");
        }

    }

}
