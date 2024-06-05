package com.solo.mavreickshub;

import com.solo.mavreickshub.models.Media;
import com.solo.mavreickshub.repository.MediaRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@Sql(scripts = {"/db/data.sql"})
@Slf4j
public class MediaRepositoryTest {
    @Autowired
    private MediaRepository mediaRepository;

    @Test
    public void findAllMediaFor(){
        List<Media> media = mediaRepository.findAllMediaFor(200L);
        log.info("items->{}", media);
        assertThat(media).
                hasSize(3);

    }
}
