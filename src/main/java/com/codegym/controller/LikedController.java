package com.codegym.controller;

import com.codegym.model.Liked;
import com.codegym.service.intf.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("liked")
public class LikedController {
    @Autowired
    private LikedService likedService;

    @GetMapping
    public ResponseEntity<List<Liked>> showAll() {
        List<Liked> likedList = likedService.findAll();
        return new ResponseEntity<>(likedList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody Liked liked) {
        likedService.save(liked);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Liked liked) {
        liked.setId(id);
        likedService.save(liked);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        likedService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
