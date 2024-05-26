package javatest.yinyong;

public class Person {
    private String name;

    public void setName(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    private void rename(Person p) {
        p.setName("李四");
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setName("张三");

        Person p2 = new Person();
        p2.setName("李四");
        System.out.println("before:" + p1.getName() + ";" + p2.getName());
        swapPerson(p1, p2);
        System.out.println("after:" + p1.getName() + ";" + p2.getName());
    }
    private static void swapPerson (Person p1, Person p2){
        Person tmp = new Person();
        p1 = tmp;
        tmp = p2;
        p2 = p1;
    }
}
