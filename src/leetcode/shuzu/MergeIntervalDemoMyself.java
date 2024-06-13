package leetcode.shuzu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalDemoMyself {
    public int[][] merge(int[][] intervals){
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
}
