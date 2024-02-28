package com.codegym.repository;

import com.codegym.model.ReThread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReThreadRepository extends JpaRepository<ReThread, Long> {
}
