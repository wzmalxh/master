package javatest.fanxing;

import java.util.ArrayList;
import java.util.List;

public class FanXingStringObject {
    public static void main(String[] args) {
        List<Object> objectList;
        List<String> stringList;

        // 编译错误，不能向子类扩展
       /* objectList = stringList;*/


        List<?> listOfAnyType;
        List<Object> listOfObject = new ArrayList<Object>();
        List<String> listOfString = new ArrayList<String>();
        List<Integer> listOfInteger = new ArrayList<Integer>();

        listOfAnyType = listOfString;// 编译正确
        listOfAnyType = listOfInteger;// 编译正确
        /**
         * List<String>不能赋值给List<Object>
         */
      /*  listOfObject =  listOfString;// 编译错误*/


    }
}
