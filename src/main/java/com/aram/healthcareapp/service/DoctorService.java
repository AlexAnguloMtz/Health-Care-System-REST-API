package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Collection<Doctor> findAll() {
        return doctorRepository.findAll();
    }

}
