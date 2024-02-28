package com.codegym.service;

import com.codegym.model.Comment;
import com.codegym.service.impl.CommentService;

import java.util.List;
import java.util.Optional;

public class CommentImpl implements CommentService {
    @Override
    public void save(Comment comment) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Optional<Comment> findEById(Long id) {
        return Optional.empty();
    }
}
