package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.UploadMediaRequest;
import com.solo.mavreickshub.dtos.response.UploadMediaResponse;
import com.solo.mavreickshub.models.Media;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.solo.mavreickshub.models.Category.ACTION;
import static com.solo.mavreickshub.utils.TestUtils.TEST_VIDEO_LOCATION;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
@Sql(scripts = {"/db/data.sql"})
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;

    @Test
    public void uploadMediaTest() {
        String fileLocation = "C:\\Users\\DELL\\Downloads\\mavreickshub\\mavreickshub\\src\\main\\resources\\static\\download.jpg";
        Path path = Paths.get(fileLocation);
        try (var inputStream = Files.newInputStream(path)) {
            UploadMediaRequest request = buildUploadMediaRequest(inputStream);
            UploadMediaResponse response = mediaService.upload(request);
            assertThat(response).isNotNull();
            assertThat(response.getUrl()).isNotNull();

        } catch (IOException exception) {
            assertThat(exception).isNull();
        }
    }

    @Test
    public void uploadVideoTest() {
        Path path = Paths.get(TEST_VIDEO_LOCATION);

        try (var inputStream = Files.newInputStream(path)) {
            UploadMediaRequest request = buildUploadMediaRequest(inputStream);
            UploadMediaResponse response = mediaService.upload(request);
            log.info("cloudinary upload response:: {}", response);
            assertThat(response).isNotNull();
            assertThat(response.getUrl()).isNotNull();

        } catch (IOException e) {
            assertThat(e).isNotNull();
        }
    }

    @Test
    public void getMediaByIdTest(){
        Media media = mediaService.getMediaById(100L);
        log.info("found content -> {}", media);
        assertThat(media).isNotNull();
    }

    private static UploadMediaRequest buildUploadMediaRequest(InputStream inputStream) throws IOException {
        UploadMediaRequest request = new UploadMediaRequest();
        MultipartFile file = new MockMultipartFile("media",inputStream);
        request.setMediaFile(file);
        request.setCategory(ACTION);
        request.setUserId(201L);

        return request;

}


}