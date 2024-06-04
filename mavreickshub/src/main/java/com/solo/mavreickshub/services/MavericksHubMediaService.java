package com.solo.mavreickshub.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.cloudinary.utils.ObjectUtils;
import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;
import com.solo.mavreickshub.exception.MediaUploadFailedException;
import com.solo.mavreickshub.models.Media;
import com.solo.mavreickshub.repository.MediaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
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

        try{

            Uploader uploader = cloudinary.uploader();
           Map<?,?> response = uploader.upload(request.getMediaFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
           log.info("cloudinary upload response:: {}", response);
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

    }

