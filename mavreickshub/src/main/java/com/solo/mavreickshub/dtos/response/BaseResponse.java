package com.solo.mavreickshub.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse <T>{
   private int code;
   private boolean status;
   private T data;
}
