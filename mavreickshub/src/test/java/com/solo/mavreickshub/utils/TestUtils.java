package com.solo.mavreickshub.utils;

import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static com.solo.mavreickshub.models.Category.ACTION;

public class TestUtils {
    public static final String TEST_VIDEO_LOCATION = "C:\\Users\\DELL\\Downloads\\mavreickshub\\mavreickshub\\src\\main\\resources\\static\\WhatsApp Video 2024-06-01 at 19.19.09_e51092eb.mp4";
    public static UploadMediaRequest buildUploadMediaRequest(InputStream inputStream) throws IOException {
        UploadMediaRequest request = new UploadMediaRequest();
        MultipartFile file = new MockMultipartFile("media", inputStream);
        request.setMediaFile(file);
        request.setCategory(ACTION);
        request.setUserId(201L);

        return request;
    }
}
