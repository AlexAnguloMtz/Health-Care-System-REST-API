package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.service.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    private Collection<Doctor> findAllDoctors() {
        return doctorService.findAll();
    }

    @GetMapping("/{id}")
    private Doctor findById(@PathVariable Integer id) {
        return doctorService.findById(id);
    }

}
