package javatest.user;

import javatest.user.dto.User;

public class UserServiceImpl implements UserService{
    @Override
    public void createUser(User user) {
        // 实现创建用户的逻辑
        System.out.println("Creating user: " + user.getName());
    }

    @Override
    public void deleteUser(int userId) {
        // 实现删除用户的逻辑
        System.out.println("Deleting user with ID: " + userId);
    }

}
