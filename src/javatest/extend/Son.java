package javatest.extend;

public class Son extends Father{

    public static void main(String[] args) {
        Son son = new Son();
        System.out.println(son.getName());
    }


}


class Father {
    private String name ="father";

    public String getName(){
        return name;
    }
}