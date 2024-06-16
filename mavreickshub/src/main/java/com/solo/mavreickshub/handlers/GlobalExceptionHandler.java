package com.solo.mavreickshub.handlers;

import com.solo.mavreickshub.exception.MediaUploadFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MediaUploadFailedException.class)
    @ResponseBody
    public ResponseEntity<?> handleMediaUploadFailed(MediaUploadFailedException exception) {
        return ResponseEntity.status(BAD_REQUEST).body(Map.of("error",exception.getMessage(),
                "success",false));

    }


}
