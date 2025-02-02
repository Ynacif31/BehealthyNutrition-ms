package com.ygornacif.Appointment_api.controller;

import com.ygornacif.Appointment_api.constants.ApiConstants;
import com.ygornacif.Appointment_api.constants.AppointmentConstants;
import com.ygornacif.Appointment_api.dto.AppointmentDto;
import com.ygornacif.Appointment_api.dto.RescheduleRequestDto;
import com.ygornacif.Appointment_api.dto.ResponseDto;
import com.ygornacif.Appointment_api.model.Appointment;
import com.ygornacif.Appointment_api.services.IAppointmentService;
import com.ygornacif.Appointment_api.services.IEmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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

    @GetMapping(path = "/{patientId}")
    public ResponseEntity<AppointmentDto> fetchAppointment(@PathVariable String patientId){
        appointmentService.fetchAppointment(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(appointmentService.fetchAppointment(patientId));
    }

    @PutMapping
    public ResponseEntity<ResponseDto> updateAppointment(@Validated @RequestBody(required = true) AppointmentDto appointmentDto) {
        boolean isUpdated = appointmentService.updateAppointment(appointmentDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ApiConstants.STATUS_417, ApiConstants.MESSAGE_417_UPDATE_FAILED));
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseDto> cancelAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
    }

    @PutMapping(path = "/{id}/reschedule")
    public ResponseEntity<ResponseDto> rescheduleAppointment(
            @PathVariable Long id,
            @RequestBody RescheduleRequestDto request) {
        appointmentService.rescheduleAppointment(id, request.getNewDate());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED)
        );
    }
}
