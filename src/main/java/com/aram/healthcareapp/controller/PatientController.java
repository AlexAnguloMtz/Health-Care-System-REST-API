package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.domain.exception.PatientDoesNotExistException;
import com.aram.healthcareapp.service.AppointmentService;
import com.aram.healthcareapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @Autowired
    PatientController(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    Collection<Patient> findAll() {
        return patientService.findAll();
    }

    @GetMapping("/{id}")
    Patient findPatient(@PathVariable Integer id) {
        return findById(id);
    }

    @GetMapping("/{id}/appointments")
    Collection<Appointment> findAppointmentsForPatient(@PathVariable Integer id) {
        Patient patient = findById(id);
        return appointmentService.findAppointmentsForPatient(patient.getId());
    }

    private Patient findById(Integer id) {
        Optional<Patient> patientOptional = patientService.findById(id);
        return patientOptional.orElseThrow(() -> new PatientDoesNotExistException(id));
    }

}
