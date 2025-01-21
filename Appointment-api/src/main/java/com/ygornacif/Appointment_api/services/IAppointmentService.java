package com.ygornacif.Appointment_api.services;

import com.ygornacif.Appointment_api.dto.AppointmentDto;

public interface IAppointmentService {

    /**
     * Cria um novo paciente.
     *
     * @param appointmentDto - AppointmentDto contendo os dados do appointment a ser criado.
     * @return AppointmentDto - DTO do appointment criado, incluindo o ID gerado.
     */
    void createAppointment(AppointmentDto appointmentDto);
}
