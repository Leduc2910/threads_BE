package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Used_image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String source;
    @ManyToOne
    private Thread thread;
}
