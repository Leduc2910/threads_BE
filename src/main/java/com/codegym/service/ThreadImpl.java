package com.codegym.service;

import com.codegym.service.impl.ThreadService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ThreadImpl implements ThreadService {
    @Override
    public void save(Thread thread) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Thread> findAll() {
        return null;
    }

    @Override
    public Optional<Thread> findEById(Long id) {
        return Optional.empty();
    }
}
