package leetcode.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 6, 7, 4, 10, 99, 15, 103};
        MergeSort m = new MergeSort();
        m.mergeSort(arr);
        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }
    }

    public void mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        mergeSortDfs(nums, left, right);

    }

    private void mergeSortDfs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSortDfs(arr, l, mid);
        mergeSortDfs(arr, mid + 1, r);

        mergeArray(arr, l, mid, r);

    }

    private void mergeArray(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];
        int i = 0;
        int j = 0;
        int cnt = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[cnt++] = L[i++];
            } else {
                arr[cnt++] = R[j++];
            }
        }
        while (i < n1) {
            arr[cnt++] = L[i++];
        }
        while (j < n2) {
            arr[cnt++] = R[j++];
        }


    }
}
