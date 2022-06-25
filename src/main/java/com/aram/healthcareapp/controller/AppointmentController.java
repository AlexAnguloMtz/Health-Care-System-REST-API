package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.service.DoctorService;
import com.aram.healthcareapp.service.MedicalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/")
public class AppointmentController {

    private final DoctorService doctorService;
    private final MedicalOfficeService medicalOfficeService;

    @Autowired
    public AppointmentController(DoctorService doctorService, MedicalOfficeService medicalOfficeService) {
        this.doctorService = doctorService;
        this.medicalOfficeService = medicalOfficeService;
    }

    @GetMapping("/doctors")
    private Collection<Doctor> findAllDoctors() {
        return doctorService.findAll();
    }


}
