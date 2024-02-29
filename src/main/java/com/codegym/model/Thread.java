package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Authorization authorization;
    private Date create_at;
    @Column(nullable = false)
    private String content;
    @ManyToOne
    private User user;
}
