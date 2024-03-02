package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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
    private final LocalDateTime create_at = LocalDateTime.now();
    private String content;
    @ManyToOne
    private User user;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_id")
    private Set<UsedImage> usedImageSet;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_id")
    private Set<Liked> likedSet;
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "thread_id")
    private Set<Comment> commentSet;
}
