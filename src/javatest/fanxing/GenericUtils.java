package javatest.fanxing;

import java.util.Arrays;

public class GenericUtils<T> {

    public static <T> void swap(T[] arr, int k, int m) {
        if (arr.length >= k && arr.length >= m){
            //交换泛型数组中的两个元素
            T temp = arr[k];
            arr[k] = arr[m];
            arr[m] = temp;
        }
    }

    public static void main(String[] args) {
        Integer []intArray = {1,2,3};
        System.out.println("Before swap: " + Arrays.toString(intArray));
        swap(intArray, 0, 1);
        System.out.println("After swap: " + Arrays.toString(intArray));

        // 使用String数组
        String[] stringArray = {"hello", "world"};
        System.out.println("Before swap: " + Arrays.toString(stringArray));
        swap(stringArray, 0, 1);
        System.out.println("After swap: " + Arrays.toString(stringArray));

        // 使用自定义对象数组
        Person[] personArray = {new Person("Alice"), new Person("Bob")};
        System.out.println("Before swap: " + Arrays.toString(personArray));
        swap(personArray, 0, 1);
        System.out.println("After swap: " + Arrays.toString(personArray));
    }


    static class Person {
        private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + '}';
    }
}
}
