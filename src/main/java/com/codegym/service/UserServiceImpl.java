package com.codegym.service;

import com.codegym.model.User;
import com.codegym.service.impl.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService{
    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findEById(Long id) {
        return Optional.empty();
    }
}
