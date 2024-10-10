package leetcode.shuzu;

import java.util.*;
import java.util.stream.Collectors;

public class MinSumKPairArray {
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        //创建priorityQueue
        int [][]array = new int[nums1.length * nums2.length][2];
        int index = 0;
        for(int i=0; i< nums1.length; i++) {
            for(int j=0; j< nums2.length; j++) {

                array[index][0] = nums1[i];
                array[index][1] = nums2[j];
                index ++ ;
            }
        }

        for(int i=0; i< array.length; i++) {
            for(int j=0 ; j< array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] + o1[0] - (o2[1] + o2[0]);
            }
        });
        for(int s=0 ; s< array.length; s++) {
            heap.add(array[s]);
        }
        while(!heap.isEmpty() && k> 0) {
            result.add(Arrays.stream(heap.poll())
                    .boxed()
                    .collect(Collectors.toList()));
            k--;
        }

    return result;
    }

    public static void main(String[] args) {
        int []nums1 = {1,7,11};
        int [] nums2 = {2,4,6};
        List<List<Integer>> res = kSmallestPairs(nums1,nums2,3);
        for(List<Integer> ll: res) {
            for(int s: ll) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
