package com.codegym.service.intf;

import com.codegym.model.Relationship;
import com.codegym.model.User;

import java.util.List;

public interface RelationshipService extends IService<Relationship>{
    Relationship getRelationshipWithUserID(User user1, User user2);
    Relationship getRelationshipWithUserIDAndStatus(User user1, User user2, int status);
    List<Relationship> getFollower(Long id);
    List<Relationship> getFollowing(Long id);
}
