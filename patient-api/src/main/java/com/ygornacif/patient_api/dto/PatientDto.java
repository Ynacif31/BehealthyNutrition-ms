package com.ygornacif.patient_api.dto;

import com.ygornacif.patient_api.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class PatientDto {

    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotNull(message = "Birth date cannot be null")
    private Date birthDate;

    @NotNull(message = "Weight cannot be null")
    private Double weight;

    @NotNull(message = "Height cannot be null")
    private Double height;

    private Double imc;

    private Gender gender;
}
