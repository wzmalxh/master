package leetcode.shuzu;

public class MergeTwoSortedArray {
    /**
     * 合并两个有序数组
     */
    public static int[] solutions(int []num1, int []num2){
        int []res = new int[num1.length + num2.length];
        int i=0;
        int j=0;
        int cnt =0;
        while(i< num1.length && j < num2.length){
            if(num1[i]< num2[j]){
                res[cnt] = num1[i];
                i++;
                cnt ++;
            }else{
                res[cnt] = num2[j];
                j++;
                cnt ++;
            }
        }
        while (j < num2.length){
            res[cnt++] = num2[j++];
        }
        while (i < num1.length){
            res[cnt++] = num1[i++];
        }
        return res;
    }


    public static void main(String[] args) {
        int []a = {1,2,4,8,12};
        int []b = {3,7,9};
        int []result = solutions(a,b);
        for(int i=0 ; i< result.length; i++){
            System.out.print(result[i]+ " ");
        }
    }

}
