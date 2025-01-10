package com.ygornacif.patient_api.controller;

import com.ygornacif.patient_api.constants.PatientConstants;
import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.dto.ResponseDto;
import com.ygornacif.patient_api.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PatientController {

    private IPatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPatient(@Validated @RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(PatientConstants.STATUS_201, PatientConstants.MESSAGE_201));
    }
}
