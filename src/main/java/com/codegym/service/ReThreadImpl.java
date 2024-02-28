package com.codegym.service;

import com.codegym.model.ReThread;
import com.codegym.service.impl.ReThreadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReThreadImpl implements ReThreadService {
    @Override
    public void save(ReThread reThread) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ReThread> findAll() {
        return null;
    }

    @Override
    public Optional<ReThread> findEById(Long id) {
        return Optional.empty();
    }
}
