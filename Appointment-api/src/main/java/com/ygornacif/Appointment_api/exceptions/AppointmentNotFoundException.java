package com.ygornacif.Appointment_api.exceptions;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppointmentNotFoundException extends RuntimeException {
    public AppointmentNotFoundException(@NotEmpty @Email String string) {
        super("Patient not found");
    }
}
