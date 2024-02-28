package com.codegym.service;

import com.codegym.model.Liked;
import com.codegym.repository.LikedRepository;
import com.codegym.service.impl.LikedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LikedImpl implements LikedService {
    @Autowired
    private LikedRepository likedRepository;
    @Override
    public void save(Liked liked) {
        likedRepository.save(liked);
    }

    @Override
    public void delete(Long id) {
    likedRepository.deleteById(id);
    }

    @Override
    public List<Liked> findAll() {
        return likedRepository.findAll();
    }

    @Override
    public Optional<Liked> findEById(Long id) {
        return likedRepository.findById(id);
    }
}
