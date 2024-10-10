package leetcode.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> resultIntervals = new ArrayList<>();
        int index = 0;
        while (index < intervals.length-1) {
            for (int k = index + 1; k < intervals.length;k++ ) {
                while ( k < intervals.length && intervals[index][1] >= intervals[k][0]) {
                    //说明可以进行区间的合并
                    intervals[index][1] = Math.max(intervals[k][1], intervals[index][1]);
                    k++;
                }
                resultIntervals.add(intervals[index]);
                index = k;
                break;
            }
        }
        if (index < intervals.length) {
            //说明还差最后一个元素没有添加
            resultIntervals.add(intervals[intervals.length-1]);
        }

        //最后将结果集转换为二维数组
        int[][] result = new int[resultIntervals.size()][2];
        // 遍历列表，将每个一维数组复制到二维数组的相应行中
        for (int i = 0; i < resultIntervals.size(); i++) {
            // 初始化当前行的列数（即列表中当前一维数组的长度）
            result[i] = new int[resultIntervals.get(i).length];

            // 将一维数组的元素复制到二维数组的当前行
            for (int j = 0; j < resultIntervals.get(i).length; j++) {
                result[i][j] = resultIntervals.get(i)[j];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] array = {
                {1, 3},
                {2, 6},
                {8,10},
                {15,18}
        };
        int[][] array2 = {
                {1, 4},
                {0, 2},
                {3, 5}
        };
        int[][] res = merge(array2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }

    }
}
