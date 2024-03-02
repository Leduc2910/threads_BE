package com.codegym.service.intf;

import com.codegym.model.User;

public interface UserService extends IService<User> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}
