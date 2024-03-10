package com.codegym.service.intf;

import com.codegym.model.User;

import java.util.List;

public interface UserService extends IService<User> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
    List<User> findAllExpectID(Long id);
    List<User> findAllByUsernameOrName(String value);
}
