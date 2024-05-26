package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class MinArrowBreakBallonsDemo {
    public static void main(String[] args) {

    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] < o2[1]){
                    return  -1;
                }else if(o1[1] > o2[1]){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        int res = 1;
        int minValue = points[0][1];
        for(int k=0; k < points.length; k++){
            if(minValue < points[k][0]){
                res ++;
                minValue = points[k][1];
            }
        }
        return res;
    }
}
