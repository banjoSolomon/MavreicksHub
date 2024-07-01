package com.solo.mavreickshub.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SendMailRequest {
    private String email;
    private String subject;
    private String recipientName;
    private String content;
}
