package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Re_thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToOne
    private Thread thread;
}
