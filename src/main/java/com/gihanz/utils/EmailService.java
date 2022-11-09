package com.gihanz.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
@Configuration
public class EmailService {

    private JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void sendEmail(String toMail,String subject,String messageDaa) {

        final String from = "eranga.egb.soft@gmail.com";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(toMail);
        message.setSubject(subject);
        message.setText(messageDaa);
        mailSender.send(message);
    }

}
