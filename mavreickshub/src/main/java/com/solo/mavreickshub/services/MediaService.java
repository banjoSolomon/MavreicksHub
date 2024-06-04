package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request);

    UploadMediaResponse uploadVideo(UploadMediaRequest request);
}
