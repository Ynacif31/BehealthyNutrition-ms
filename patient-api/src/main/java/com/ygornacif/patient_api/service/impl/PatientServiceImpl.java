package com.ygornacif.patient_api.service.impl;

import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.entities.Patient;
import com.ygornacif.patient_api.exceptions.PatientAlreadyExistsException;
import com.ygornacif.patient_api.exceptions.PatientNotFoundException;
import com.ygornacif.patient_api.exceptions.ResourceNotFoundException;
import com.ygornacif.patient_api.mapper.PatientMapper;
import com.ygornacif.patient_api.repositories.PatientRepository;
import com.ygornacif.patient_api.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public void createPatient(PatientDto patientDto) {
        validatePatientExistence(patientDto);

        Patient patient = PatientMapper.mapToPatient(patientDto, new Patient());
        patientRepository.save(patient);
    }


    @Override
    public PatientDto fetchPatient(String mobileNumber) {
        Patient patient = (Patient) patientRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", "mobileNumber", mobileNumber));

        PatientDto patientDto = PatientMapper.mapToPatientDto(patient, new PatientDto());
        if (patientDto == null) {
            throw new IllegalStateException("Failed to map Patient to PatientDto");
        }

        return patientDto; // Número já deve estar mapeado no DTO
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) {
        Patient patient = patientRepository.findByEmail(patientDto.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("Patient", "email", patientDto.getEmail())
        );

        PatientMapper.mapToPatient(patientDto, patient); // Map only updated fields.
        patientRepository.save(patient);
        return true;
    }

    @Override
    public boolean deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient with id " + id + " not found.")
        );
        patientRepository.delete(patient);
        return true;
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(
                () -> new PatientNotFoundException("Patient with id " + id + " not found.")
        );
        return PatientMapper.mapToPatientDto(patient, new PatientDto());

    }

    private void validatePatientExistence(PatientDto patientDto) {
        Optional<Patient> patient = patientRepository.findByEmail(patientDto.getEmail());
        if (patient.isPresent()) {
            throw new PatientAlreadyExistsException("Patient with email " + patientDto.getEmail() + " already exists.");
        }
        if (patientRepository.findByMobileNumber(patientDto.getMobileNumber()).isPresent()) {
            throw new PatientAlreadyExistsException("Patient with mobile number " + patientDto.getMobileNumber() + " already exists.");
        }
    }
}
