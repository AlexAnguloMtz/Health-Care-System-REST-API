package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/patients")
class PatientController {

    private final PatientService patientService;

    @Autowired
    PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/all")
    Collection<Patient> findAll() {
        return patientService.findAll();
    }

}
