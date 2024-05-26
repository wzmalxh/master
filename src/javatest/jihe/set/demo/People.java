package javatest.jihe.set.demo;

public class People {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    People(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int hashCode()
    {
        System.out.println(this.name+"....hashCode");
        return name.hashCode()+age*37;  //保证此元素的返回值尽量不一致。
    }


    public boolean equals(Object obj)
    {

        if(!(obj instanceof People))
            return false;

        People p = (People)obj;
        //如果打印这行，说明创建相同对象之前会调用equals
        System.out.println(this.name+"...equals.."+p.name);

        return this.name.equals(p.name) && this.age == p.age;
    }

}
