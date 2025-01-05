package leetcode.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalDemoMyself {
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int []> resultMergeList = new ArrayList<>();

        for (int i = 0; i < intervals.length; ++i){
            int L = intervals[i][0];
            int R = intervals[i][1];
            if(resultMergeList.size() ==0 || resultMergeList.get(resultMergeList.size()-1)[1] < L){
                resultMergeList.add(new int[]{L,R});
            }else{
                resultMergeList.get(resultMergeList.size()-1)[1] = Math.max(R,resultMergeList.get(resultMergeList.size()-1)[1]);
            }
        }

        return resultMergeList.toArray(new int[resultMergeList.size()][]);
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
        int[][] res = merge(array);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j <= 1; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }

    }
}
