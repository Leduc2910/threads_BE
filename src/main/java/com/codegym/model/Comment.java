package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Thread thread;
    @Column(nullable = false)
    private String content;
    private Date create_at;
}
