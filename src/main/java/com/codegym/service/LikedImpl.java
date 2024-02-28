package com.codegym.service;

import com.codegym.model.Liked;
import com.codegym.service.impl.LikedService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikedImpl implements LikedService {
    @Override
    public void save(Liked liked) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Liked> findAll() {
        return null;
    }

    @Override
    public Optional<Liked> findEById(Long id) {
        return Optional.empty();
    }
}
