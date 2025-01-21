package com.ygornacif.Appointment_api.exceptions;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AppointmentAlreadyExistsException extends RuntimeException {
    public AppointmentAlreadyExistsException(String email) {
        super("Patient with email " + email + " already exists");
    }
}
