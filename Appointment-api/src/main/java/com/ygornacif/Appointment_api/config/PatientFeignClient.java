package com.ygornacif.Appointment_api.config;

import com.ygornacif.Appointment_api.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url = "http://localhost:8090/api/patients")
public interface PatientFeignClient {

    @GetMapping("/{patientId}")
    PatientDto getPatientById(@PathVariable String patientId);
}