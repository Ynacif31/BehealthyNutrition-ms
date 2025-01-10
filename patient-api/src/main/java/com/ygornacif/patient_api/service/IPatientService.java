package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.PatientDto;
import com.ygornacif.patient_api.entities.Patient;

public interface IPatientService {

    /**
     * Cria um novo paciente.
     *
     * @param patientDto - PatientDto contendo os dados do paciente a ser criado.
     * @return PatientDto - DTO do paciente criado, incluindo o ID gerado.
     */
    void createPatient(PatientDto patientDto);

    /**
     * Atualiza os dados de um paciente.
     *
     * @param patientDto - PatientDto contendo os dados do paciente a ser atualizado.
     * @return boolean indicando se a atualização foi bem-sucedida ou não.
     */
    boolean updatePatient(PatientDto patientDto);
}
