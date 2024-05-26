package javatest.user;

import javatest.user.dto.User;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class PermissionControlDemo {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        Set<String> allowedMethods = new HashSet<>();
        allowedMethods.add("createUser"); // 假设只有createUser方法被允许

        Principal principal = new Principal() {
            @Override
            public String getName() {
                return "admin"; // 假设当前用户是admin
            }
        };

        UserService proxyUserService = PermissionInvocationHandler.createProxy(
                UserService.class, userService, allowedMethods, principal
        );

        try {
            // 允许的调用
            proxyUserService.createUser(new User("Alice"));

            // 不允许的调用，将抛出SecurityException
            proxyUserService.deleteUser(1);
        } catch (SecurityException e) {
            System.err.println("Access denied: " + e.getMessage());
        }
    }
}