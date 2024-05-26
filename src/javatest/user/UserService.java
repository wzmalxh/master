package javatest.user;

import javatest.user.dto.User;

public interface UserService {
    void createUser(User user);
    void deleteUser(int userId);
}
