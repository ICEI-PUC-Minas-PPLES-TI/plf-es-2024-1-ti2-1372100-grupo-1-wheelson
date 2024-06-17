package com.renatomatos.wheelson.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import com.itextpdf.text.DocumentException;
import com.renatomatos.wheelson.util.Email;

import java.io.File;
import java.io.IOException;

@Service
public class EmailService {

    @Autowired
    private final JavaMailSender mailSender;
    @Autowired
    private final BoletoService boletoService;

    
    public EmailService(JavaMailSender mailSender, BoletoService boletoService) {
        this.mailSender = mailSender;
        this.boletoService = boletoService;
    }

    public void sendEmail(Email email, String nomeSacado, String cpfSacado, double valorAluguel) {
        if (email == null ||email.getTo() == null || email.getTo().isEmpty() || email.getSubject() == null || email.getSubject().isEmpty() || email.getBody() == null || email.getBody().isEmpty()) {
            throw new IllegalArgumentException("Os parâmetros de e-mail não podem ser nulos ou vazios");
        }

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("wheelson@gmail.com");
            helper.setTo(email.getTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getBody(), true); // true indica que o corpo do email é HTML

            // Gerando o boleto e anexando ao email
            File boleto = boletoService.gerarBoleto(nomeSacado, cpfSacado, valorAluguel);
            FileSystemResource file = new FileSystemResource(boleto);
            helper.addAttachment("boleto.pdf", file);

            mailSender.send(message);

            // Deletar o arquivo temporário após envio
            boleto.delete();
        } catch (MessagingException | IOException e) {
            throw new RuntimeException("Falha ao enviar e-mail", e);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
