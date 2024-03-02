package com.codegym.repository;

import com.codegym.model.Relationship;
import com.codegym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    Relationship getRelationshipByUser1AndUser2(User user1,User user2);
    Relationship getRelationshipByUser1AndUser2AndStatus(User user1,User user2, int status);
}
