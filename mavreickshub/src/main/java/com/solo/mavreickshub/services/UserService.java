package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.CreateUserRequest;
import com.solo.mavreickshub.dtos.response.CreateUserResponse;
import com.solo.mavreickshub.models.User;

public interface UserService {


    CreateUserResponse register(CreateUserRequest request);

    User getById(long l);

   User getUserByUsername(String username);
}
