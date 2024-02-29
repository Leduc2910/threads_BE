package com.codegym.service;

import com.codegym.model.ReThread;
import com.codegym.repository.ReThreadRepository;
import com.codegym.service.intf.ReThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReThreadImpl implements ReThreadService {
    @Autowired
    private ReThreadRepository reThreadRepository;

    @Override
    public void save(ReThread reThread) {
        reThreadRepository.save(reThread);
    }

    @Override
    public void delete(Long id) {
        reThreadRepository.deleteById(id);

    }

    @Override
    public List<ReThread> findAll() {
        return reThreadRepository.findAll();
    }

    @Override
    public Optional<ReThread> findEById(Long id) {
        return reThreadRepository.findById(id);
    }
}
