package com.codegym.service;

import com.codegym.service.intf.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ThreadImpl implements ThreadService {
    @Autowired
    private ThreadService threadService;
    @Override
    public void save(Thread thread) {
        threadService.save(thread);

    }

    @Override
    public void delete(Long id) {
        threadService.delete(id);

    }

    @Override
    public List<Thread> findAll() {
        return threadService.findAll();
    }

    @Override
    public Optional<Thread> findEById(Long id) {
        return threadService.findEById(id);
    }
}
