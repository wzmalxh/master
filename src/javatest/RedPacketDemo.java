package javatest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RedPacketDemo {
    public static List<Integer> distributeRedPackets(int m, int n, int x, int y) {
        // 边界条件检查
        if (m < n * x || m > n * y || n <= 0 || x <= 0 || y <= 0 || x > y) {
            throw new IllegalArgumentException("Invalid input parameters for red packet distribution.");
        }

        List<Integer> redPackets = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n - 1; i++) {
            // 计算当前分配红包后的剩余金额
            int remaining = m - i * x;
            // 计算当前红包金额的最大可能值
            int maxPossible = Math.min(y, remaining / (n - i));
            // 随机选择一个在[x, maxPossible]之间的红包金额
            int amount = 0;
            if(maxPossible > x){
                amount = x + random.nextInt(maxPossible - x + 1);
            }else{
                amount = x + random.nextInt(x- maxPossible + 1);
            }

            // 更新剩余金额
            m -= amount;
            // 将红包金额添加到列表中
            redPackets.add(amount);
        }

        // 最后一个红包的金额就是剩余金额
        redPackets.add(m);

        return redPackets;
    }

    public static void main(String[] args) {
        int m = 100; // 总金额
        int n = 10; // 红包数量
        int x = 8; // 每个红包最小金额
        int y = 30; // 每个红包最大金额

        List<Integer> redPackets = distributeRedPackets(m, n, x, y);
        if (redPackets != null) {
            System.out.println("红包分配方案：");
            for (int amount : redPackets) {
                System.out.println(amount + "元");
            }
        } else {
            System.out.println("无法分配红包。");
        }
    }
}
