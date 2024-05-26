package leetcode.shuzu;

public class SortedArrayDeleteDuplicateDemo {
    public int deleteDuplicates(int[] arr) {
        if (arr == null) {
            return 0;
        }
        if (arr.length < 3) {
            return arr.length;
        }
        int cnt = 2;
        for (int i = cnt; i < arr.length; i++) {
            if (arr[i] != arr[cnt - 2]) {
                arr[cnt++] = arr[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        SortedArrayDeleteDuplicateDemo demo = new SortedArrayDeleteDuplicateDemo();
        int[] array = {1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8};
        int res = demo.deleteDuplicates(array);
        for (int i = 0; i < res; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        System.out.println("result =" + res);
    }


}
