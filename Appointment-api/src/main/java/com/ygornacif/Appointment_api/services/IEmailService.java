package com.ygornacif.Appointment_api.services;

import com.ygornacif.Appointment_api.dto.EmailDto;

public interface IEmailService {

    public void sendEmail(EmailDto emailDto);
}
