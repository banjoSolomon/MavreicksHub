package com.solo.mavreickshub.dtos.response;

import com.solo.mavreickshub.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMediaResponse {
    private Long id;
    private String url;
    private String description;
    private Category category;
}
