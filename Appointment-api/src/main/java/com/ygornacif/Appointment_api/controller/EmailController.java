package com.ygornacif.Appointment_api.controller;

import com.ygornacif.Appointment_api.dto.EmailDto;
import com.ygornacif.Appointment_api.services.IEmailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    private final IEmailService emailService;

    public EmailController(IEmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Void> sendEmail(@Valid @RequestBody EmailDto emailDto) {
        emailService.sendEmail(emailDto);
        return ResponseEntity.noContent().build();
    }
}
