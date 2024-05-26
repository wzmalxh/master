package leetcode.sort;

import java.util.PriorityQueue;

public class KPeakSort {
    /**
     * PriorityQueue实现堆排序
     * @param array
     * @param k
     * @return
     */
    public int[] peakK(int [] array, int k){
        int []result = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2) -> o1 - o2);
        for(int i = 0; i< array.length; i++){
            heap.add(array[i]);
        }
        for(int i = 0; i< k; i++) {
            result[i] = heap.poll();

        }
        return result;
    }

    public static void main(String[] args) {
        int [] arr = {2,36,758,95,100,13,64,6};
        KPeakSort k = new KPeakSort();
        int []result = k.peakK(arr, 3);
        for(int h = 0; h< 3; h++){
            System.out.println(result[h]);
        }
    }
}
