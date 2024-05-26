package javatest.base;

public class FindMaxDemo {
    public static void main(String[] args) {
        int [] arr = {1,2,1,3,5,6,4};
        FindMaxDemo demo = new FindMaxDemo();
        System.out.println(demo.peakNumIndex(arr));
    }

    public int peakNumIndex(int []arr){

        if(arr == null || arr.length <= 2){
            return -1;
        }
        int i = 0;
        int j = arr.length -1;
        while(i < j){
            int middle = (i + j) / 2;
            if(arr[middle] > arr[middle-1] && arr[middle] > arr[middle+1]){
                return middle;
            }else if(arr[middle] < arr[middle+1]){
                i = middle + 1;
            }else{
                j = middle;
            }
        }
        return i;
    }
}
