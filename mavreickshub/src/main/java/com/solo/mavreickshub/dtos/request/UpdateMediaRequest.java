package com.solo.mavreickshub.dtos.request;

import com.solo.mavreickshub.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMediaRequest {
    private Long id;
    private String description;
    private Category category;

}
