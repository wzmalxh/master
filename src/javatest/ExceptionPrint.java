package javatest;

public class ExceptionPrint {

    public  static int div(int a,int b){
        try{
            int c = a/b;
            return  c;
        }catch (Exception e){
            System.out.println("Exception");
        }finally {
            System.out.println("finally");
        }
        return  0;
    }

    public static void main(String[] args) {
        int k = div(9,0);
        System.out.println("result ="+k);
    }
}
