package com.solo.mavreickshub.dtos.request;

import com.solo.mavreickshub.models.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class UpdateMediaRequest {

    @Id
    private Long id;
    private String description;
    private Category uploader;

}
