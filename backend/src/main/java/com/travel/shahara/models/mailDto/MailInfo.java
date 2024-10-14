package com.travel.shahara.models.mailDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailInfo {
    private String from;
    private String to;
    private String subject;
    private String body;

    private final static String FROM_ADDRESS = "Shahara <shahara@gmail.com>";

    public MailInfo(String to, String subject, String body) {
        this.from = FROM_ADDRESS;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
