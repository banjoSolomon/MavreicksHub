package com.solo.mavreickshub.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Entity
@Getter
@Setter
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String description;
    private Category category;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeCreated;
    @Setter(AccessLevel.NONE)
    private LocalDateTime timeUpdated;
    @ManyToOne
    private User user;

    @PrePersist
    private void setTimeCreated() {
        this.timeCreated =  now();
    }

    @PreUpdate
    private void setTimeUpdated() {
        this.timeCreated =  now();
    }


}
