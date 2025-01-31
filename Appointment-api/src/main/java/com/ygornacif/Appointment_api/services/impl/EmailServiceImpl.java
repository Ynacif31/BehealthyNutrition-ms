package com.ygornacif.Appointment_api.services.impl;

import com.ygornacif.Appointment_api.dto.EmailDto;
import com.ygornacif.Appointment_api.exceptions.EmailException;
import com.ygornacif.Appointment_api.services.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailServiceImpl implements IEmailService {

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(EmailDto emailDto) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(emailDto.getTo());
            message.setSubject(emailDto.getSubject());
            message.setText(emailDto.getBody());
            emailSender.send(message);
        } catch (MailException e) {
            throw new EmailException("Failed to send email");
        }
    }
}
