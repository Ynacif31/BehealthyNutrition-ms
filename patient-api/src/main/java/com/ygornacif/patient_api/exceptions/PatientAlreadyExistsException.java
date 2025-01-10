package com.ygornacif.patient_api.exceptions;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PatientAlreadyExistsException extends RuntimeException {
    public PatientAlreadyExistsException(@NotEmpty(message = "Email address cannot be null or empty") @Email(message = "Email address should be a valid value") String email) {
        super("Patient already exists");
    }
}
