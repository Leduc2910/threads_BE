package com.codegym.service;

import com.codegym.model.ReThread;
import com.codegym.service.intf.ReThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReThreadImpl implements ReThreadService {
    @Autowired
    private ReThreadService reThreadService;

    @Override
    public void save(ReThread reThread) {
        reThreadService.save(reThread);
    }

    @Override
    public void delete(Long id) {
        reThreadService.delete(id);

    }

    @Override
    public List<ReThread> findAll() {
        return reThreadService.findAll();
    }

    @Override
    public Optional<ReThread> findEById(Long id) {
        return reThreadService.findEById(id);
    }
}
