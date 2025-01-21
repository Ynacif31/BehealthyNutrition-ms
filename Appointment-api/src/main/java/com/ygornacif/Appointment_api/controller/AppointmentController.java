package com.ygornacif.Appointment_api.controller;

import com.ygornacif.Appointment_api.constants.ApiConstants;
import com.ygornacif.Appointment_api.constants.AppointmentConstants;
import com.ygornacif.Appointment_api.dto.AppointmentDto;
import com.ygornacif.Appointment_api.dto.ResponseDto;
import com.ygornacif.Appointment_api.services.IAppointmentService;
import com.ygornacif.Appointment_api.services.impl.AppointmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/appointments", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ResponseDto> createAppointment(@Validated @RequestBody AppointmentDto appointmentDto){
        appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.status((HttpStatus.CREATED)).body(new ResponseDto(ApiConstants.STATUS_201, AppointmentConstants.MESSAGE_201));
    }
}
