package com.ygornacif.Appointment_api.services;

import com.ygornacif.Appointment_api.dto.AppointmentDto;

import java.time.LocalDateTime;

public interface IAppointmentService {

    /**
     * Cria um novo paciente.
     *
     * @param appointmentDto - AppointmentDto contendo os dados do appointment a ser criado.
     * @return AppointmentDto - DTO do appointment criado, incluindo o ID gerado.
     */
    void createAppointment(AppointmentDto appointmentDto);

    /**
     *
     * @param patientId - Input Mobile Number
     * @return Accounts Details based on a given mobileNumber
     */
    AppointmentDto fetchAppointment(String patientId);

    /**
     * @param appointmentDto - AppointmentDto Object
     * @return boolean indicating if the update of appointment details is successful or not
     */
    boolean updateAppointment(AppointmentDto appointmentDto);

    /**
     * Atualiza os dados de um paciente.
     *
     * @param id - id do paciente a ser excluido.
     * @return boolean indicando se a deleção foi bem-sucedida ou não.
     */
    boolean deleteAppointment(Long id);

    boolean rescheduleAppointment(Long id, LocalDateTime newDate);
}
