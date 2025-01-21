package com.ygornacif.Appointment_api.services.impl;

import com.ygornacif.Appointment_api.dto.AppointmentDto;
import com.ygornacif.Appointment_api.mappers.AppointmentMapper;
import com.ygornacif.Appointment_api.model.Appointment;
import com.ygornacif.Appointment_api.repository.AppointmentRepository;
import com.ygornacif.Appointment_api.services.IAppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.mapToAppointmentFromDto(appointmentDto, new Appointment());
        appointmentRepository.save(appointment);
    }
}
