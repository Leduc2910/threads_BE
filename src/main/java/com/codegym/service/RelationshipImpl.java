package com.codegym.service;

import com.codegym.model.Relationship;
import com.codegym.service.impl.RelationshipService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RelationshipImpl implements RelationshipService {
    @Override
    public void save(Relationship relationship) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Relationship> findAll() {
        return null;
    }

    @Override
    public Optional<Relationship> findEById(Long id) {
        return Optional.empty();
    }
}
