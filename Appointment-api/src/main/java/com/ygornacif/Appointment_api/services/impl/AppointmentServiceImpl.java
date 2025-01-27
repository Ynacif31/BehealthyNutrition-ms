package com.ygornacif.Appointment_api.services.impl;

import com.ygornacif.Appointment_api.dto.AppointmentDto;
import com.ygornacif.Appointment_api.exceptions.AppointmentNotFoundException;
import com.ygornacif.Appointment_api.mappers.AppointmentMapper;
import com.ygornacif.Appointment_api.model.Appointment;
import com.ygornacif.Appointment_api.repository.AppointmentRepository;
import com.ygornacif.Appointment_api.services.IAppointmentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@Service
public class AppointmentServiceImpl implements IAppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public void createAppointment(AppointmentDto appointmentDto) {
        Appointment appointment = AppointmentMapper.mapToAppointmentFromDto(appointmentDto, new Appointment());
        appointmentRepository.save(appointment);
    }

    @Override
    public AppointmentDto fetchAppointment(String patientId) {
        Appointment appointment = appointmentRepository.findByPatientId(patientId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return AppointmentMapper.mapToAppointment(new AppointmentDto(), appointment);
    }

    @Override
    public boolean updateAppointment(AppointmentDto appointmentDto) {
        if (appointmentDto == null) {
            return false;
        }

        return appointmentRepository.findByPatientId(appointmentDto.getPatientId())
                .map(appointment -> {
                    AppointmentMapper.mapToAppointmentFromDto(appointmentDto, appointment);
                    appointmentRepository.save(appointment);
                    return true;
                })
                .orElse(false);
    }

    @Override
    public boolean deleteAppointment(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException("Appointment with id " + id + " not found."));

        appointmentRepository.delete(appointment);
        return true;
    }
}
