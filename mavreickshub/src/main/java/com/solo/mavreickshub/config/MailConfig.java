package com.solo.mavreickshub.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class MailConfig {
    @Value("${mail.api.key}")
    private String mailApikey;
    @Value("${mail.api.url}")
    private String mailApiUrl;


}
