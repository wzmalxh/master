package javatest.inteer;

public interface InterfaceDemo {
    static final int test = 10;

    String str = "测试接口是否可以有成员属性";

    /**
     * 注释的部分无法通过编译，说明接口中不可以有具体的方法实现
     * @return
     */
   /* public String get(){
        return "wangzimeng";
    }*/
}
