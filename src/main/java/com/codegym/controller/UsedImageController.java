package com.codegym.controller;

import com.codegym.model.UsedImage;
import com.codegym.service.intf.UsedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@CrossOrigin("*")
@RequestMapping("image")
public class UsedImageController {
    @Autowired
    private UsedImageService usedImageService;

    @GetMapping
    public ResponseEntity<List<UsedImage>> showAll() {
        List<UsedImage> usedImageList = usedImageService.findAll();
        return new ResponseEntity<>(usedImageList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@Validated @RequestBody UsedImage usedImage) {
        usedImageService.save(usedImage);
        return new ResponseEntity<>("Thêm thành công", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> edit(@PathVariable Long id, @RequestBody UsedImage usedImage) {
        usedImage.setId(id);
        usedImageService.save(usedImage);
        return new ResponseEntity<>("Sửa thành công", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        usedImageService.delete(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.OK);
    }
}
