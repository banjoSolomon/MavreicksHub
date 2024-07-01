package com.solo.mavreickshub.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.MediaResponse;
import com.solo.mavreickshub.dtos.response.UpdateMediaResponse;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;
import com.solo.mavreickshub.exception.MediaNotFoundException;
import com.solo.mavreickshub.exception.MediaUpdateFailedException;
import com.solo.mavreickshub.exception.MediaUploadFailedException;
import com.solo.mavreickshub.models.Media;
import com.solo.mavreickshub.models.User;
import com.solo.mavreickshub.repository.MediaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

@Service
@Slf4j
@AllArgsConstructor
public class MavericksHubMediaService implements  MediaService {

    private final MediaRepository mediaRepository;
    private final  Cloudinary cloudinary;
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) {
        User user= userService.getById(request.getUserId());

        try{

            Uploader uploader = cloudinary.uploader();
           Map<?,?> response = uploader.upload(request.getMediaFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
           log.info("cloudinary upload response:: {}", response);
           String url = response.get("url").toString();
           Media media =  modelMapper.map(request, Media.class);
           media.setUrl(url);
           media.setUploader(user);
           media = mediaRepository.save(media);
           return modelMapper.map(media, UploadMediaResponse.class);
        }catch(Exception exception){
            throw new MediaUploadFailedException(exception.getMessage());

        }

    }

    @Override
    public UploadMediaResponse uploadVideo(UploadMediaRequest request) {
        try{
            Uploader uploader = cloudinary.uploader();
            Map<?,?> response = uploader.upload(request.getMediaFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            String url = response.get("url").toString();
            Media media =  modelMapper.map(request, Media.class);
            media.setUrl(url);
            media = mediaRepository.save(media);
            return modelMapper.map(media, UploadMediaResponse.class);
        }catch(Exception exception){
            throw new MediaUploadFailedException(exception.getMessage());

        }
    }

    @Override
    public Media getMediaById(long id) {
        return mediaRepository.findById(id)
                .orElseThrow(()-> new MediaNotFoundException("media not found"));
    }

    @Override
    public UpdateMediaResponse update(long mediaId, JsonPatch jsonPatch) {
       try{
           //1. get target object
        Media media = getMediaById(mediaId);
        //2. covert object from above to JasonNode (use ObjectMapper)
        ObjectMapper objectMapper = new ObjectMapper();
       JsonNode mediaNode = objectMapper.convertValue(media, JsonNode.class);
       //3. apply jasonPatch to mediaNode
       mediaNode = jsonPatch.apply(mediaNode);
       //4. convert mediaNode to media object
       media = objectMapper.convertValue(media, Media.class);
       media = mediaRepository.save(media);
       return modelMapper.map(media, UpdateMediaResponse.class);
    }catch (JsonPatchException e){
           throw new MediaUpdateFailedException(e.getMessage());
       }


       }

    @Override
    public List<MediaResponse> getMediaFor(Long userId) {
        userService.getById(userId);
      List<Media> media = mediaRepository.findAllMediaFor(userId);
        return media.stream()
                .map(mediaItem->modelMapper.map(mediaItem,MediaResponse.class)).toList();
    }

}

