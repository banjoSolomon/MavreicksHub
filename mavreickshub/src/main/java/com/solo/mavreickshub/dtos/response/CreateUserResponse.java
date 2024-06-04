package com.solo.mavreickshub.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserResponse {
    private String message;
    private  Long id;
    private String email;
}
