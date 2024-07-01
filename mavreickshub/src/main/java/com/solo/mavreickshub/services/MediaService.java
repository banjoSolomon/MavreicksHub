package com.solo.mavreickshub.services;

import com.github.fge.jsonpatch.JsonPatch;
import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.MediaResponse;
import com.solo.mavreickshub.dtos.response.UpdateMediaResponse;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;
import com.solo.mavreickshub.models.Media;

import java.util.List;

public interface MediaService {
    UploadMediaResponse upload(UploadMediaRequest request);

    UploadMediaResponse uploadVideo(UploadMediaRequest request);

    Media getMediaById(long id);

    UpdateMediaResponse update(long mediaId, JsonPatch updateMediaRequest);

    List<MediaResponse> getMediaFor(Long userId);

}
