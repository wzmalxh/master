package javatest;

public class ArrayPointerTest {
    public static void main(String[] args) {
        int []array = {1,2,3,4,5};
        modify(array);
        System.out.println();
        for(int k =0; k< array.length; k++){
            System.out.print(array[k]+" ");
        }
    }
    public static void modify(int []ary) {
        if(ary != null){
            ary[0] = -1;
            for(int i=0; i<ary.length; i++){
                System.out.print(ary[i] + " ");
            }
        }
    }
}
