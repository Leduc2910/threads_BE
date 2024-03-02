package com.codegym.controller;

import com.codegym.model.Authorization;
import com.codegym.service.intf.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("authorization")
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    @GetMapping
    public ResponseEntity<List<Authorization>> showAll() {
        List<Authorization> authorizationList = authorizationService.findAll();
        return new ResponseEntity<>(authorizationList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody Authorization authorization) {
        authorizationService.save(authorization);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Authorization authorization) {
        authorization.setId(id);
        authorizationService.save(authorization);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        authorizationService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
