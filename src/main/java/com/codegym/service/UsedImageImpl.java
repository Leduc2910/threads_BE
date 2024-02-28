package com.codegym.service;

import com.codegym.model.UsedImage;
import com.codegym.service.impl.UsedImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsedImageImpl implements UsedImageService {
    @Autowired
    private UsedImageService usedImageService;
    @Override
    public void save(UsedImage usedImage) {
        usedImageService.save(usedImage);

    }

    @Override
    public void delete(Long id) {
        usedImageService.delete(id);

    }

    @Override
    public List<UsedImage> findAll() {
        return usedImageService.findAll();
    }

    @Override
    public Optional<UsedImage> findEById(Long id) {
        return usedImageService.findEById(id);
    }
}
