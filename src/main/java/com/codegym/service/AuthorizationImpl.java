package com.codegym.service;

import com.codegym.model.Authorization;
import com.codegym.repository.AuthorizationRepository;
import com.codegym.service.intf.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AuthorizationImpl implements AuthorizationService {
    @Autowired
    private AuthorizationRepository authorizationRepository;
    @Override
    public void save(Authorization authorization) {
        authorizationRepository.save(authorization);
    }

    @Override
    public void delete(Long id) {
        authorizationRepository.deleteById(id);
    }

    @Override
    public List<Authorization> findAll() {
        return authorizationRepository.findAll();
    }

    @Override
    public Optional<Authorization> findEById(Long id) {
        return authorizationRepository.findById(id);
    }
}
