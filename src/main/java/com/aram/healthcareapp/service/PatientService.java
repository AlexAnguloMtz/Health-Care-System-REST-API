package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Collection<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }
}
