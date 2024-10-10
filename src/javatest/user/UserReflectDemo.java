package javatest.user;

import javatest.user.dto.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> clazz = User.class;
        System.out.println("—————————————————获取User实例—————————————————————————");
        User user = (User) clazz.newInstance();
        user.setName("wang");
        System.out.println("user is: " + user);


        clazz = Class.forName("javatest.user.dto.User");
        User user2 = (User) clazz.newInstance();
        user2.setName("Chen Yidan");
        System.out.println("user is: " + user2);


        //获取指定字段名称的Field类,注意字段修饰符必须为public而且存在该字段,
        Field[] fields = clazz.getDeclaredFields();
        for (Field ff : fields) {
            System.out.println("Declared fields name is :" + ff.getName());
        }
        System.out.println("——————————————————————————————————————————————");
        Field[] fieldsPublic = clazz.getFields();
        for (Field ff : fieldsPublic) {
            System.out.println("Declared Public fields name is :" + ff.getName());
        }
        System.out.println("——————————————————————————————————————————————");
        Class<?> clazzUserImpl = UserServiceImpl.class;
        UserService userNewService = (UserService) clazzUserImpl.newInstance();
        try{
            Method method = clazzUserImpl.getDeclaredMethod("createUser", User.class);
            method.invoke(userNewService, user);

        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
