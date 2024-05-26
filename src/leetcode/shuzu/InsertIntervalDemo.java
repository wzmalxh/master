package leetcode.shuzu;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalDemo {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                result.add(intervals[i]);

            } else {
                while(i < intervals.length && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]){
                    int minValue = Math.min(newInterval[0], intervals[i][0]);
                    int maxValue = Math.max(newInterval[1], intervals[i][1]);
                    newInterval[0] = minValue;
                    newInterval[1] = maxValue;
                    i++;
                }
                result.add(newInterval);
            }
        }
        int[][] newIntervals = new int[result.size()][2];
        int cnt = 0;
        for (int k = 0; k < result.size(); k++) {
            newIntervals[cnt++] = result.get(k);
        }
        return newIntervals;

    }


    public static int[][] insertNew(int[][] intervals, int[] newInterval) {
        List<int[]> ret = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        //左侧区间
        while (i < n && intervals[i][1] < newInterval[0]) {
            ret.add(intervals[i]);
            i++;
        }
        //区间重叠 开始节点 一定小于等于newInterval的结束值 结束结点一定大于等于newInterval的开始值
        while (i < n && intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
            //更新interval的值
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ret.add(newInterval);

        //右侧区间
        while (i < n && intervals[i][0] > newInterval[1]) {
            ret.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[ret.size()][];
        for (int k = 0; k < ret.size(); ++k) {
            ans[k] = ret.get(k);
        }
        return ans;
    }
}
