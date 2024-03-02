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
    @PostMapping
    public ResponseEntity<String> follow(@RequestParam String username1, @RequestParam String username2) {
        User user1 = userService.findUserByUsername(username1);
        User user2 = userService.findUserByUsername(username2);
        Relationship checkFollow = relationshipService.getRelationshipWithUserID(user1, user2);
        if (checkFollow == null) {
            Relationship relationship = new Relationship();
            relationship.setUser1(user1);
            relationship.setUser2(user2);
            if (user2.getStatus() == 1) {
                relationship.setStatus(0);
                relationshipService.save(relationship);
                return new ResponseEntity<>("Đã yêu cầu", HttpStatus.OK);
            } else {
                relationshipService.save(relationship);
                return new ResponseEntity<>("Theo dõi thành công", HttpStatus.OK);
            }
        } else {
            relationshipService.delete(checkFollow.getId());
            if (checkFollow.getStatus() == 0) {
                return new ResponseEntity<>("Hủy yêu cầu", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Xóa người theo dõi", HttpStatus.OK);
            }
        }
    }
    @PutMapping
    public ResponseEntity<String> acceptReq(@RequestParam String username1, @RequestParam String username2) {
        User user1 = userService.findUserByUsername(username1);
        User user2 = userService.findUserByUsername(username2);
        Relationship acptReq = relationshipService.getRelationshipWithUserIDAndStatus(user2, user1, 0);
        if (acptReq != null) {
            acptReq.setStatus(1);
            relationshipService.save(acptReq);
            return  new ResponseEntity<>("Đã chấp nhận", HttpStatus.OK);
        }
        return new ResponseEntity<>("Không tồn tại", HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> delFollow(@RequestParam String username1, @RequestParam String username2) {
        User user1 = userService.findUserByUsername(username1);
        User user2 = userService.findUserByUsername(username2);
        Relationship delFollow = relationshipService.getRelationshipWithUserID(user2, user1);
        if (delFollow != null) {
            relationshipService.delete(delFollow.getId());
            if (delFollow.getStatus() == 0) {
                return  new ResponseEntity<>("Từ chối yêu cầu", HttpStatus.OK);
            } else {
                return  new ResponseEntity<>("Xóa người theo dõi", HttpStatus.OK);
            }

        }
        return new ResponseEntity<>("Không tồn tại", HttpStatus.OK);
    }
}
