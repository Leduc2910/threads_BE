package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UsedImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
}
