package leetcode.sort;

public class KBigInArray {
    /**
     * 求数组中第k大的元素
     */
    public static int[] quick(int [] a, int start, int end){
        int i= start;
        int j = end -1;
        //todo 标准值a[i]，第一趟排序求出来左边都是比a[i] 小的，右边都是比a[i]大的
        int pivot = a[i];
        while(i < j){
            while(i < j && pivot <= a[j]) {
                j--;
            }
            a[i] = a[j];
            while(j > i && pivot > a[i]) {
                i++;
            }
            a[j] = a[i];

        }
        a[i] = pivot;
        if (i > start) {
            a = quick(a, start, i);
        }
        if (i  < end-1) {
            a = quick(a, i + 1, end);
        }
        return a;
    }

    public static void main(String[] args) {
        int []a = {6,1,3,4,2};
        int []b = quick(a,0,5);
        for(int i=0; i< b.length; i++){
            System.out.println(b[i]);
        }
    }
}
