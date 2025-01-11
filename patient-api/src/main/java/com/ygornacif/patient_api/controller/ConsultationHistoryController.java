package com.ygornacif.patient_api.controller;

import com.ygornacif.patient_api.constants.PatientConstants;
import com.ygornacif.patient_api.dto.ConsultationHistoryDto;
import com.ygornacif.patient_api.dto.ResponseDto;
import com.ygornacif.patient_api.service.IConsultationHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ConsultationHistoryController {
    
    private final IConsultationHistoryService consultationHistoryService;
    
    @PostMapping("/create-history")
    public ResponseEntity<ResponseDto> createHistory(@Validated @RequestBody ConsultationHistoryDto consultationHistoryDto) {
        consultationHistoryService.createConsultationHistory(consultationHistoryDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(PatientConstants.STATUS_201, PatientConstants.MESSAGE_201));
    }

    @GetMapping("/fetch-history/{patientId}")
    public ResponseEntity<List<ConsultationHistoryDto>> fetchHistory(@PathVariable Long patientId) {
        List<ConsultationHistoryDto> consultationHistoryList = consultationHistoryService.fetchConsultationHistoryByPatientId(patientId);
        return ResponseEntity.status(HttpStatus.OK).body(consultationHistoryList);
    }
}
