package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.MedicalOffice;
import com.aram.healthcareapp.service.MedicalOfficeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/medical-offices")
class MedicalOfficeController {

    private final MedicalOfficeService medicalOfficeService;


    public MedicalOfficeController(MedicalOfficeService medicalOfficeService) {
        this.medicalOfficeService = medicalOfficeService;
    }

    @GetMapping("/all")
    Collection<MedicalOffice> findAll() {
        return medicalOfficeService.findAll();
    }

}
