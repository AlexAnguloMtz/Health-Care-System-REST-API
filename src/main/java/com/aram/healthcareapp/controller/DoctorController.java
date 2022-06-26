package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.service.AppointmentService;
import com.aram.healthcareapp.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;
import java.util.Optional;

import static com.aram.healthcareapp.domain.ErrorCode.DOCTOR_DOES_NOT_EXIST;

@RestController
@RequestMapping("/doctors")
class DoctorController {

    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    public DoctorController(DoctorService doctorService, AppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    Collection<Doctor> findAll() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Doctor> findDoctor(@PathVariable Integer id) {
        Doctor doctor = findById(id);
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }

    @GetMapping("/{id}/appointments")
    Collection<Appointment> findAppointmentsForDoctor(@PathVariable Integer id) {
        Doctor doctor = findById(id);
        return appointmentService.findAppointmentsForDoctor(doctor.getId());
    }

    Doctor findById(Integer id) {
        Optional<Doctor> doctorOptional = doctorService.findById(id);
        return doctorOptional.orElseThrow(
                () -> new RuntimeException(DOCTOR_DOES_NOT_EXIST.toString()));
    }

    @PostMapping
    ResponseEntity<Doctor> save(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.save(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctorRequestBody, @PathVariable Integer id) {
        Optional<Doctor> oldDoctorOptional = doctorService.findById(id);
        if(oldDoctorOptional.isPresent()) {
            Doctor oldDoctor = oldDoctorOptional.get();
            Doctor newDoctor = mapRequestBodyToNewDoctor(oldDoctor, doctorRequestBody);
            Doctor savedDoctor = doctorService.save(newDoctor);
            return new ResponseEntity<>(savedDoctor, HttpStatus.OK);
        }
        Doctor savedDoctor = doctorService.save(doctorRequestBody);
        return new ResponseEntity<>(savedDoctor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    HttpStatus deleteDoctor(@PathVariable Integer id) {
        doctorService.deleteDoctor(id);
        return HttpStatus.OK;
    }

    private Doctor mapRequestBodyToNewDoctor(Doctor oldDoctor, Doctor doctorRequestBody) {
        return new Doctor(
                oldDoctor.getId(),
                doctorRequestBody.getName(),
                doctorRequestBody.getSpeciality()
        );
    }

}
