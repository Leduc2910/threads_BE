package com.codegym.repository;

import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);

    List<User> findByIdNot(Long id);
    List<User> findByUsernameContainingAndNameContaining(String value1, String value2);
}
