package javatest.kuaishou;

import java.util.Random;

public class Mianshi1 {
    //m 为总数，n为红包数量，x是每个红包最小值，y为每个红包最大值
    public static void printMoney(int m, int n, int x,int y){
        int moneyLeft = m -  y - (n-1) * x;
        int []a = new int[n];
        a[0] = x;
        a[n-1] = y;
        for(int i= 1; i< n-1; i++){
            a[i] = x;
        }
        int avg = moneyLeft / (n -2);
        System.out.println("avg = "+ avg);

        int left = moneyLeft % (n-2);
        System.out.println("left =" + left);
        for(int i=1 ; i< n-1; i++){
            if(a[i] + avg  <  y ){
                a[i] = a[i] + avg;
            }else if(a[i] - avg >= x){
                a[i]  -= avg;
            }
        }

        if((a[1] + left) < y){
            a[1] += left;
        }else if(a[1] - left > x){
            a[1] -= left;
        }
        for(int i=0;i < n; i++){
            System.out.println(a[i]);
        }
    }


    public static void allocateRedEnvelopes(int totalAmount, int envelopeCount, int minAmount, int maxAmount) {
        if (totalAmount < envelopeCount * minAmount) {
            System.out.println("总金额不足以分配最小金额的红包！");
            return;
        }
        if (maxAmount < minAmount) {
            System.out.println("最大金额必须大于或等于最小金额！");
            return;
        }

        Random rand = new Random();
        int[] envelopes = new int[envelopeCount];
        int remainingAmount = totalAmount;

        for (int i = 0; i < envelopeCount - 1; i++) {
            // 生成一个介于[minAmount, maxAmount]之间的随机数，但不超过剩余金额
            int amount = Math.min(rand.nextInt(maxAmount - minAmount + 1) + minAmount, remainingAmount / (envelopeCount - i));
            envelopes[i] = amount;
            remainingAmount -= amount;
        }

        // 最后一个红包的金额是剩余金额
        envelopes[envelopeCount - 1] = remainingAmount;

        // 输出分配结果
        for (int i = 0; i < envelopeCount; i++) {
            System.out.println("红包" + (i + 1) + "：" + envelopes[i] + "元");
        }
    }


    public static void main(String[] args) {
        int m = 100,n = 60, x= 1, y =3;
        printMoney(m,n,x,y);
        //allocateRedEnvelopes(100,10,6,20);
    }
}
