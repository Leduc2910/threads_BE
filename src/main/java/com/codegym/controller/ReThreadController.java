package com.codegym.controller;

import com.codegym.model.ReThread;
import com.codegym.service.intf.ReThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("reThread")
public class ReThreadController {
    @Autowired
    private ReThreadService reThreadService;

    @GetMapping
    public ResponseEntity<List<ReThread>> showAll() {
        List<ReThread> reThreadList = reThreadService.findAll();
        return new ResponseEntity<>(reThreadList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody ReThread reThread) {
        reThreadService.save(reThread);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody ReThread reThread) {
        reThread.setId(id);
        reThreadService.save(reThread);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        reThreadService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
