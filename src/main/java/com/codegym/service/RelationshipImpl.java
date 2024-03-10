package com.codegym.service;

import com.codegym.model.Relationship;
import com.codegym.model.User;
import com.codegym.repository.RelationshipRepository;
import com.codegym.service.intf.RelationshipService;
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

    @Override
    public Relationship getRelationshipWithUserID(User user1, User user2) {
        return relationshipRepository.getRelationshipByUser1AndUser2(user1,user2);
    }

    @Override
    public Relationship getRelationshipWithUserIDAndStatus(User user1, User user2, int status) {
        return relationshipRepository.getRelationshipByUser1AndUser2AndStatus(user1,user2, status);
    }

    @Override
    public List<Relationship> getFollower(Long id) {
        return relationshipRepository.getByUser2Id(id);
    }

    @Override
    public List<Relationship> getFollowing(Long id) {
        return relationshipRepository.getByUser1Id(id);
    }
}
