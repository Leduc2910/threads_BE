package com.codegym.controller;

import com.codegym.model.Relationship;
import com.codegym.model.User;
import com.codegym.service.intf.RelationshipService;
import com.codegym.service.intf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("relationship")
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Relationship>> showAll() {
        List<Relationship> relationships = relationshipService.findAll();
        return new ResponseEntity<>(relationships, HttpStatus.OK);
    }
    @GetMapping("follower")
    public ResponseEntity<List<Relationship>> getAllFollower(@RequestParam Long id) {
        List<Relationship> relationships = relationshipService.getFollower(id);
        return new ResponseEntity<>(relationships, HttpStatus.OK);
    }
    @GetMapping("following")
    public ResponseEntity<List<Relationship>> getAllFollowing(@RequestParam Long id) {
        List<Relationship> relationships = relationshipService.getFollowing(id);
        return new ResponseEntity<>(relationships, HttpStatus.OK);
    }
    @GetMapping("check")
    public ResponseEntity<Relationship> checkFollowBetween2User(@RequestParam Long id1, @RequestParam Long id2) {
        User user1 = userService.findEById(id1).get();
        User user2 = userService.findEById(id2).get();
        Relationship relationship = relationshipService.getRelationshipWithUserIDAndStatus(user1, user2, 1);
        return new ResponseEntity<>(relationship, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<String> follow(@RequestBody Relationship relationship) {
        relationshipService.save(relationship);
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delFollow(@RequestParam Long id1, @RequestParam Long id2) {
        User user1 = userService.findEById(id1).get();
        User user2 = userService.findEById(id2).get();
        Relationship delFollow = relationshipService.getRelationshipWithUserID(user1, user2);
        relationshipService.delete(delFollow.getId());
        return new ResponseEntity<>("Thành công", HttpStatus.OK);
    }
}
