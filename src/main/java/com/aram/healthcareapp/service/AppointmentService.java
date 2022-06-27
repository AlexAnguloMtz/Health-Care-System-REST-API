package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Transactional
    public Collection<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Transactional
    public Collection<Appointment> findAppointmentsForDoctor(Integer doctorId) {
        return appointmentRepository.findAllByDoctorId(doctorId);
    }

    @Transactional
    public Collection<Appointment> findAppointmentsForPatient(Integer patientId) {
        return appointmentRepository.findAllByPatientId(patientId);
    }
}
