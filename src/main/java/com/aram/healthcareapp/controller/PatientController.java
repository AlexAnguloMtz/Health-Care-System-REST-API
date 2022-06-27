package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.domain.exception.ResourceDoesNotExistException;
import com.aram.healthcareapp.service.AppointmentService;
import com.aram.healthcareapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

import static java.lang.String.format;

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

    @PostMapping
    ResponseEntity<Patient> savePatient(@RequestBody @Valid Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return new ResponseEntity<Patient>(savedPatient, HttpStatus.CREATED);
    }

    private Patient findById(Integer id) {
        Optional<Patient> patientOptional = patientService.findById(id);
        return patientOptional.orElseThrow(
                () -> new ResourceDoesNotExistException(format("This patient does not exist", id)));
    }

}
