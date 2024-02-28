package com.codegym.service;

import com.codegym.model.UsedImage;
import com.codegym.service.impl.UsedImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsedImageImpl implements UsedImageService {
    @Override
    public void save(UsedImage usedImage) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UsedImage> findAll() {
        return null;
    }

    @Override
    public Optional<UsedImage> findEById(Long id) {
        return Optional.empty();
    }
}
