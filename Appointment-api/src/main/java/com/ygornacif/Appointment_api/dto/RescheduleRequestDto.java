package com.ygornacif.Appointment_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RescheduleRequestDto {

    private LocalDateTime newDate;
}
