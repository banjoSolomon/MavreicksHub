package com.solo.mavreickshub.repository;

import com.solo.mavreickshub.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<Media, Long> {
}