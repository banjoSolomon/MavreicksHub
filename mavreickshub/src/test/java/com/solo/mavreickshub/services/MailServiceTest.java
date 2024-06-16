package com.solo.mavreickshub.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;
    @Test
    public void testSendEmail() {
        String email = "ayomidebanjo02@gmail.com";
       String response = mailService.sendMail(email);
       assertThat(response).isNotNull();
       assertThat(response).containsIgnoringCase("success");

    }
}
