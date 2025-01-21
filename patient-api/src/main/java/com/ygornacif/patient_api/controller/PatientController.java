package com.ygornacif.patient_api.controller;

import com.ygornacif.patient_api.constants.ApiConstants;
import com.ygornacif.patient_api.constants.PatientConstants;
import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.dto.ResponseDto;
import com.ygornacif.patient_api.service.IPatientService;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/patients", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class PatientController {

    private final IPatientService patientService;

    @PostMapping
    public ResponseEntity<ResponseDto> createPatient(@Validated @RequestBody PatientDto patientDto) {
        patientService.createPatient(patientDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(ApiConstants.STATUS_201, PatientConstants.MESSAGE_201));
    }
    
    
    @GetMapping
    public ResponseEntity<PatientDto> fetchPatient(@RequestParam @Pattern(regexp="(^$|[0-9]{11})",message = "Mobile number must be 11 digits")
                                                    String mobileNumber) {
        PatientDto patientDto = patientService.fetchPatient(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(patientDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto> updatePatient(
            @Validated @RequestBody PatientDto patientDto,
            @PathVariable Long id) {
        patientService.updatePatient(patientDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(ApiConstants.STATUS_200, ApiConstants.MESSAGE_200_PROCESSED));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(ApiConstants.STATUS_200, "Patient deleted successfully."));
    }
}