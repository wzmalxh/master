package leetcode.shuzu;

import java.util.Arrays;
import java.util.Comparator;

public class MaxUnOverlapInterval {
    /**
     * 最大不重叠区间的个数
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        //定义排序比较器
        if (intervals == null) {
            return 0;
        }
        //统计不重叠的区间个数
        int notOverlapNum = 1;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] = o2[1];
            }
        });
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int rightEdge = intervals[0][1];
        for(int k= 1; k< intervals.length; k++) {
            if (intervals[k][0] >= rightEdge) {
                rightEdge = intervals[k][1];
                notOverlapNum++;
            }
        }
        return intervals.length - notOverlapNum;
    }
}
