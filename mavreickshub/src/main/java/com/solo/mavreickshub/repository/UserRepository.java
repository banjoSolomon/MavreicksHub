package com.solo.mavreickshub.repository;

import com.solo.mavreickshub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
