package com.ygornacif.patient_api.service;

import com.ygornacif.patient_api.dto.PatientDto;

public interface IPatientService {

    /**
     * Cria um novo paciente.
     *
     * @param patientDto - PatientDto contendo os dados do paciente a ser criado.
     * @return PatientDto - DTO do paciente criado, incluindo o ID gerado.
     */
    void createPatient(PatientDto patientDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    PatientDto fetchPatient(String mobileNumber);

    /**
     * @param patientDto - PatientDto Object
     * @return boolean indicating if the update of patient details is successful or not
     */
    boolean updatePatient(PatientDto patientDto);
    /**
     * Atualiza os dados de um paciente.
     *
     * @param id - id do paciente a ser excluido.
     * @return boolean indicando se a deleção foi bem-sucedida ou não.
     */
    boolean deletePatient(Long id);

    /**
     * Busca um paciente pelo ID.
     *
     * @param id - ID do paciente a ser buscado.
     * @return PatientDto contendo os dados do paciente.
     */
    PatientDto getPatientById(Long id);
}
