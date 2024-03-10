package com.codegym.controller;

import com.codegym.model.Thread;
import com.codegym.service.intf.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("thread")
public class ThreadController {
    @Autowired
    private ThreadService threadService;

    @GetMapping
    public ResponseEntity<List<Thread>> showAll() {
        List<Thread> threadList = threadService.findAllByCreateAt();
        return new ResponseEntity<>(threadList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Thread> getThreadById(@PathVariable Long id) {
        Thread thread = threadService.findEById(id).get();
        return new ResponseEntity<>(thread, HttpStatus.OK);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Thread>> getThreadByUserID(@PathVariable Long id) {
        List<Thread> threadList = threadService.findAllByUserID(id);
        return new ResponseEntity<>(threadList, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> create(@RequestBody Thread thread) {
        threadService.save(thread);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody Thread thread) {
        thread.setId(id);
        threadService.save(thread);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        threadService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
