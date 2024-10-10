package javatest.user.dto;

public class User {
    private String name;

    private int age;

    public User(String name){
        this.name = name;
    }

    public User() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
