package com.solo.mavreickshub.controllers;

import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.services.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/media")
@AllArgsConstructor
public class MediaController {

    private final MediaService mediaService;
    @PostMapping(consumes= {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadMedia(@ModelAttribute UploadMediaRequest uploadMediaRequest){
    return ResponseEntity.status(CREATED).body(mediaService.upload(uploadMediaRequest));

    }
    @GetMapping
    public ResponseEntity<?> getMediaFor(@RequestParam Long userId){
        return ResponseEntity.ok(mediaService.getMediaFor(userId));
    }
}
