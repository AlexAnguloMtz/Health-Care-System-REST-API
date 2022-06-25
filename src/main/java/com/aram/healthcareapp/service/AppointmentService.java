package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.repository.AppointmentRepository;

import java.util.Collection;

public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public Collection<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

}
