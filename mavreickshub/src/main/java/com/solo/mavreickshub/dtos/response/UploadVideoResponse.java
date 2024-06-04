package com.solo.mavreickshub.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadVideoResponse {
    String url;
    Long videoId;
    String description;

}
