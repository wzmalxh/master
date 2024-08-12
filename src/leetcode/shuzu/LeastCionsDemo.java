package leetcode.shuzu;

import java.util.Arrays;

public class LeastCionsDemo {

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int sum = 0;
        int minCoin = Integer.MAX_VALUE;
        int n = coins.length -1;
        while(n >= 0) {
            sum = 0;
            for(int i = n ; i >= 0 ; i--){
                if (amount >= coins[i]){
                    int num = amount / coins[i];
                    amount -= coins[i] * num;
                    sum += num;
                }else{
                    continue;
                }
                if(amount == 0){
                    minCoin = Math.min(minCoin,sum);
                    break;
                }
            }
            n--;
        }
        return minCoin;

    }

    public static void main(String[] args) {
        int []arr = {186,419,83,408};
        int amount = 6249;
        System.out.println(coinChange(arr,amount));
    }
}
