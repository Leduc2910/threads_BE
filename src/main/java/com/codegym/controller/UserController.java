package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userIService;

    @GetMapping("")
    public ResponseEntity<List<User>> showAll() {
        List<User> userList = userIService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<String> create(@RequestBody User user) {
        userIService.save(user);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        userIService.save(user);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        userIService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
    @GetMapping("@{username}")
    public ResponseEntity<User> getDetailUser(@PathVariable String username) {
        User user = userIService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User currentUser = userIService.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (currentUser != null) {
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        }
        return new ResponseEntity<>("Sai thông tin tài khoản hoặc mật khẩu", HttpStatus.UNAUTHORIZED);
    }
    @PostMapping("register")
    public ResponseEntity<String> register(@Validated @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        } else {
            User newUser = userIService.findUserByUsername(user.getUsername());
            if (newUser != null) {
                return new ResponseEntity<>("Tài khoản đã tồn tại", HttpStatus.BAD_REQUEST);
            } else {
                userIService.save(user);
                return new ResponseEntity<>("Đăng ký thành công", HttpStatus.OK);
            }
        }
    }
}
