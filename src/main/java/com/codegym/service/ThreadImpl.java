package com.codegym.service;

import com.codegym.model.Thread;
import com.codegym.repository.ThreadRepository;
import com.codegym.service.intf.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ThreadImpl implements ThreadService {
    @Autowired
    private ThreadRepository threadRepository;

    @Override
    public void save(Thread thread) {
        threadRepository.save(thread);
    }

    @Override
    public void delete(Long id) {
        threadRepository.deleteById(id);
    }

    @Override
    public List<Thread> findAll() {
        return threadRepository.findAll();
    }

    @Override
    public Optional<Thread> findEById(Long id) {
        return threadRepository.findById(id);
    }

    @Override
    public List<Thread> findAllByCreateAt() {
        return threadRepository.findByOrderByIdDesc();
    }

    @Override
    public List<Thread> findAllByUserID(Long userId) {
        return threadRepository.findByUserId(userId);
    }
}
