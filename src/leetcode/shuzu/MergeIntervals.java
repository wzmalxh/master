package leetcode.shuzu;

import java.util.Arrays;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        //获取数组长度
        int length = intervals.length;
        int[][] result = new int[length][2];
        //对数组的左端点进行排序
        Arrays.sort(intervals,(x,y)->{
            return x[0] - y[0];
        });
        //将第一个值直接放入数组初始化
        result[0] = intervals[0];
        int count = 0;
        for(int i = 1; i < length; i++){
            if(intervals[i][0] > result[count][1]){
                count+=1;
                result[count] = intervals[i];
            }else{
                //因为左端点排序之后不知道右端点到底是大是小的
                result[count][1] = Math.max(intervals[i][1], result[count][1]);
            }
        }
        return Arrays.copyOf(result, count+1);

    }


    public static void main(String[] args) {
        int a[][]={{1,3},{2,6},{8,10},{15,18}};
        int [][]res = merge(a);
        for (int i=0; i< res.length ; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
