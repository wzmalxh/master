package leetcode.sort;

public class QuickSort {
    public static int[] quickSort(int[] num, int l ,int r) {
//r为数组元素总个数，last下标等于r-1
        int first = l, last = r - 1, key = num[first];
        while (first < last) {
            while (first < last && num[last] >= key) {
                --last;
            }
            //如果值小于 key分界值 交换
            num[first] = num[last];
            while (first < last && num[first] < key) {
                ++first;
            }
            //如果值大于key分界值 交换
            num[last] = num[first];
        }
        num[first] = key;
        //递归左右部分进行快排
        if (first > l) {
            num = quickSort(num, l, first);
        }
        if (first  < r-1) {
            num = quickSort(num, first + 1, r);
        }
        return num;
    }

    public static void main(String[] args) {
        int []arr = {5,1,3,7,4,6,8,2};
        quickSortSum(arr);
        for(int i=0 ; i< arr.length-1; i++){
            System.out.println(arr[i]);
        }

    }

    private static void quickSortSum(int[] arr) {
        int begin = 0;
        int end = arr.length;
        quickSort(arr,begin,end);
    }
}
