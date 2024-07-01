package com.solo.mavreickshub.services;

import com.solo.mavreickshub.dtos.request.SendMailRequest;

public interface MailService {
    String sendMail(SendMailRequest request);
}
