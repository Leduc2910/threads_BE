package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userIService;
    @GetMapping
    public ResponseEntity<List<User>> showAll() {
        List<User> productList = userIService.findAll();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody User user) {
        userIService.save(user);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id,  @RequestBody User user) {
        user.setId(id);
        userIService.save(user);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id) {
        userIService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }

}
