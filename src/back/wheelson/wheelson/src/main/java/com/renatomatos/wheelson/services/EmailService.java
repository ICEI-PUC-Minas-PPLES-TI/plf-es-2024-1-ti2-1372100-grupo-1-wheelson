package com.renatomatos.wheelson.services;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
    
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String body) {
        if (to == null || to.isEmpty() || subject == null || subject.isEmpty() || body == null || body.isEmpty()) {
            throw new IllegalArgumentException("Os parâmetros de e-mail não podem ser nulos ou vazios");
        }

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("wheelson@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}
