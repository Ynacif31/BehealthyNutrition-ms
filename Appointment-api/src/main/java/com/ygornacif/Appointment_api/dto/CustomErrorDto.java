package com.ygornacif.Appointment_api.dto;

import lombok.*;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomErrorDto {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

}