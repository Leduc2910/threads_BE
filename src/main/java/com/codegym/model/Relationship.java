package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Relationship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user1;
    @ManyToOne
    private User user2;
    private int status;
}
