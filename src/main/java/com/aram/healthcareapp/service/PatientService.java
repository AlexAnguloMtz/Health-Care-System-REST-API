package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.domain.SocialSecurityNumber;
import com.aram.healthcareapp.domain.exception.ResourceAlreadyExistsException;
import com.aram.healthcareapp.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Transactional
    public Collection<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Transactional
    public Optional<Patient> findById(Integer id) {
        return patientRepository.findById(id);
    }

    @Transactional
    public Patient save(Patient patient) {
        if(alreadyExists(patient)) {
            throw new ResourceAlreadyExistsException("This patient already exists");
        }
        return patientRepository.save(patient);
    }

    private boolean alreadyExists(Patient patient) {
        SocialSecurityNumber socialSecurityNumber = patient.getSocialSecurityNumber();
        Optional<Patient> patientOptional = patientRepository
                .findBySocialSecurityNumber(socialSecurityNumber);

        return patientOptional.isPresent();
    }
}
