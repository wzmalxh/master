package javatest.user;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.Principal;
import java.util.Set;

public class PermissionInvocationHandler implements InvocationHandler {
    private final Object target;
    private final Set<String> allowedMethods;
    private final Principal principal;

    public PermissionInvocationHandler(Object target, Set<String> allowedMethods, Principal principal) {
        this.target = target;
        this.allowedMethods = allowedMethods;
        this.principal = principal;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 检查方法调用是否允许
        if (!allowedMethods.contains(method.getName())) {
            throw new SecurityException("User does not have permission to access this method.");
        }

        // 执行方法调用
        return method.invoke(target, args);
    }

    public static <T> T createProxy(Class<T> interfaceType, T target, Set<String> allowedMethods, Principal principal) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new PermissionInvocationHandler(target, allowedMethods, principal)
        );
    }
}