package com.ygornacif.Appointment_api.mappers;

import com.ygornacif.Appointment_api.dto.AppointmentDto;
import com.ygornacif.Appointment_api.model.Appointment;

public class AppointmentMapper {

    public static AppointmentDto mapToAppointment(AppointmentDto dto, Appointment appointment){
        if (appointment == null) {
            return null;
        }

        dto.setDateTime(appointment.getDateTime());
        dto.setStatus(appointment.getStatus());
        dto.setNotes(appointment.getNotes());
        dto.setNutritionistId(appointment.getNutritionistId());
        dto.setPatientId(appointment.getPatientId());

        return dto;
    }

    public static Appointment mapToAppointmentFromDto(AppointmentDto dto, Appointment appointment){
        if (appointment == null) {
            return null;
        }

        appointment.setDateTime(dto.getDateTime());
        appointment.setStatus(dto.getStatus());
        appointment.setNotes(dto.getNotes());
        appointment.setNutritionistId(dto.getNutritionistId());
        appointment.setPatientId(dto.getPatientId());

        return appointment;
    }
}