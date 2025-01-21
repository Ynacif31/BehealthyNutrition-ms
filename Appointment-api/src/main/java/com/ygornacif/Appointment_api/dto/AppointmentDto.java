package com.ygornacif.Appointment_api.dto;

import com.ygornacif.Appointment_api.enums.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentDto {

    @NotNull(message = "Date and time cannot be null")
    private LocalDateTime dateTime;

    private String nutritionistId;

    @NotEmpty(message = "Patient ID cannot be empty")
    private String patientId;

    private String notes;

    @NotNull(message = "Status cannot be null")
    private Status status;

}