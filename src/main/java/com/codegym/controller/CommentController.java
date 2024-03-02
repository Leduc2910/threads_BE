package com.codegym.controller;

import com.codegym.model.Comment;
import com.codegym.service.intf.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> showAll() {
        List<Comment> commentList = commentService.findAll();
        return new ResponseEntity<>(commentList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody Comment comment) {
        commentService.save(comment);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        commentService.save(comment);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        commentService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
