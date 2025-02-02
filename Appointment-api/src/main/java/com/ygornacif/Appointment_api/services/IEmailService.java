package com.ygornacif.Appointment_api.services;

import com.ygornacif.Appointment_api.dto.EmailDto;

import java.time.LocalDateTime;

public interface IEmailService {
    void sendEmail(EmailDto emailDto);
    void sendAppointmentEmail(String to, LocalDateTime appointmentDate);
}