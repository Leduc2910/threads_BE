package com.codegym.repository;

import com.codegym.model.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
    List<Thread> findByOrderByIdDesc();
    List<Thread> findByUserId(Long userId);
}
