package com.aram.healthcareapp.controller;

import com.aram.healthcareapp.domain.Appointment;
import com.aram.healthcareapp.service.AppointmentService;
import com.aram.healthcareapp.service.MedicalOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/appointments")
class AppointmentController {

    private final MedicalOfficeService medicalOfficeService;
    private final AppointmentService appointmentService;

    @Autowired
    AppointmentController(MedicalOfficeService medicalOfficeService, AppointmentService appointmentService) {
        this.medicalOfficeService = medicalOfficeService;
        this.appointmentService = appointmentService;
    }

    @GetMapping("/all")
    Collection<Appointment> findAll() {
        return appointmentService.findAll();
    }


}
