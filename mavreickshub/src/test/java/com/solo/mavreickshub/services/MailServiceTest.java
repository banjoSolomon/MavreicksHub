package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.SendMailRequest;
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
        SendMailRequest sendMailRequest = new SendMailRequest();
        sendMailRequest.setEmail(email);
        sendMailRequest.setRecipientName("solomon");
        sendMailRequest.setContent("<p>Hello from me</p>");
        sendMailRequest.setSubject("Test Email");
       String response = mailService.sendMail(sendMailRequest);
       assertThat(response).isNotNull();
       assertThat(response).containsIgnoringCase("success");

    }
}
