package reflect.test;

import reflect.demo.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectPersonDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        try{
            Class<?> person = Class.forName("reflect.demo.Person");

            System.out.println("我是Person通过反射处理的类 = "+person);
            Method personMethod = person.getMethod("getGender", int.class);
            System.out.println("反射获取Person的getGender方法: "+ personMethod);
            Constructor<?> con = person.getConstructor();
            Object personObj =  con.newInstance();
            int arg = 1;
            Object res = personMethod.invoke(personObj,arg);
            System.out.println("反射调用结果："+(String)res);
        }catch (java.lang.NoSuchMethodException e){
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
