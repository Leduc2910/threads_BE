package com.codegym.service;

import com.codegym.model.User;
import com.codegym.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserImpl implements UserService{
    @Autowired
    private UserService userService;
    @Override
    public void save(User user) {
        userService.save(user);

    }

    @Override
    public void delete(Long id) {
        userService.delete(id);

    }

    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public Optional<User> findEById(Long id) {
        return userService.findEById(id);
    }
}
