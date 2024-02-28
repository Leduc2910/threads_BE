package com.codegym.service;

import com.codegym.model.Relationship;
import com.codegym.repository.RelationshipRepository;
import com.codegym.service.impl.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RelationshipImpl implements RelationshipService {
    @Autowired
    private RelationshipRepository relationshipRepository;
    @Override
    public void save(Relationship relationship) {
        relationshipRepository.save(relationship);
    }

    @Override
    public void delete(Long id) {
        relationshipRepository.deleteById(id);
    }

    @Override
    public List<Relationship> findAll() {
        return relationshipRepository.findAll();
    }

    @Override
    public Optional<Relationship> findEById(Long id) {
        return relationshipRepository.findById(id);
    }
}
