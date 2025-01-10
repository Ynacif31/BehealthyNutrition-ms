package com.ygornacif.patient_api.service.impl;

import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.entities.Patient;
import com.ygornacif.patient_api.exceptions.PatientAlreadyExistsException;
import com.ygornacif.patient_api.exceptions.PatientNotFoundException;
import com.ygornacif.patient_api.mapper.PatientMapper;
import com.ygornacif.patient_api.repositories.PatientRepository;
import com.ygornacif.patient_api.service.IPatientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    @Override
    public void createPatient(PatientDto patientDto) {
        Patient patient = PatientMapper.mapToPatient(patientDto, new Patient());
        Optional<Patient> optionalPatient = patientRepository.findByEmail(patientDto.getEmail());
        if (optionalPatient.isPresent()) {
            throw new PatientAlreadyExistsException(patientDto.getEmail());
        }
        patientRepository.save(patient);
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) {
        Optional<Patient> optionalPatient = patientRepository.findByEmail(patientDto.getEmail());
        if (optionalPatient.isEmpty()) {
            throw new PatientNotFoundException("Patient with email " + patientDto.getEmail() + " not found.");
        }

        Patient patient = optionalPatient.get();
        patient.setName(patientDto.getName());
        patient.setEmail(patientDto.getEmail());
        patient.setHeight(patientDto.getHeight());
        patient.setWeight(patientDto.getWeight());
        patientRepository.save(patient);

        return true;
    }

}
