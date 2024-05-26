package javatest;

public class StringTest {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        if(str1 == str2){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        String str3 = new String("hello");
        String str4 = "he"+"llo";
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
    }
}
