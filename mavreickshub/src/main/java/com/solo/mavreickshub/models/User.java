package com.solo.mavreickshub.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.now;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;
    private Category category;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeCreated;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeUpdated;

    @PrePersist
    private void setTimeCreated(){
        timeCreated = now();
    }

    @PreUpdate
    private void setTimeUpdated(){
        timeUpdated = now();
    }
}
