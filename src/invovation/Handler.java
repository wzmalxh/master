package invovation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Handler {


    public static void main(String[] args) {

        InvocationDemoImpl realObject = new InvocationDemoImpl();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before method call");
                Object result = method.invoke(realObject, args);
                System.out.println("After method call");
                return result;
            }
        };

        InvocationDemo proxy = (InvocationDemo) Proxy.newProxyInstance(
                InvocationDemo.class.getClassLoader(),
                new Class<?>[]{InvocationDemo.class},
                handler
        );


        String result = proxy.sayHello("World");
        System.out.println(result);
    }

}
