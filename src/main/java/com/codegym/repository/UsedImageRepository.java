package com.codegym.repository;

import com.codegym.model.UsedImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsedImageRepository extends JpaRepository<UsedImage, Long> {
}
