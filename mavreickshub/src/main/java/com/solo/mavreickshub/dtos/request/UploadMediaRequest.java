package com.solo.mavreickshub.dtos.request;

import com.solo.mavreickshub.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class UploadMediaRequest {
    private Long UserId;
    private MultipartFile mediaFile;
    private String description;
    private Category category;
}
