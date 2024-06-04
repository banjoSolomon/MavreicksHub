package com.solo.mavreickshub.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserRequest {
    private String email;
    private String password;
}
