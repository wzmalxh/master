package javatest.jihe.list;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ArrayListReSizeDemo {
    /**
     * 经过5次扩容： 10 —— 15——22——33——45——73——109，说明如果不指定大小，初识size  = 10
     * @param args
     */
    public static void main(String[] args) throws NoSuchMethodException {
        List list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            System.out.print(i + "==");
            list.add(i);
            elementDataLength(list); // 调用 elementDataLength 方法输出当前容量
        }
    }


    //这个方法主要是动态获取list对象的属性，输出size信息
    private static void elementDataLength(List list) {
        try{
            Field listClass = list.getClass().getDeclaredField("elementData");
            listClass.setAccessible(true); // 设置允许访问私有变量
            Object[] o = (Object[]) listClass.get(list); // 获取 ArrayList 中存储元素的底层数组对象的引用
            // 输出 ArrayList 的容量信息，即底层数组的长度
            System.out.println("当前List集合容量为：" + o.length);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
