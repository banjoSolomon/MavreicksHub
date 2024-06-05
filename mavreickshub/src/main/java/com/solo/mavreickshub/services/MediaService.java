package com.solo.mavreickshub.services;

import com.github.fge.jsonpatch.JsonPatch;
import com.solo.mavreickshub.dtos.request.UpdateMediaRequest;
import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.UpdateMediaResponse;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;
import com.solo.mavreickshub.models.Media;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request);

    UploadMediaResponse uploadVideo(UploadMediaRequest request);

    Media getMediaById(long id);

    UpdateMediaResponse update(long mediaId, JsonPatch updateMediaRequest);

}
