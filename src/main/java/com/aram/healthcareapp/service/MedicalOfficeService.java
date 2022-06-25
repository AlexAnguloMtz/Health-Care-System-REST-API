package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.MedicalOffice;
import com.aram.healthcareapp.repository.MedicalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MedicalOfficeService {

    private final MedicalOfficeRepository medicalOfficeRepository;

    @Autowired
    public MedicalOfficeService(MedicalOfficeRepository medicalOfficeRepository) {
        this.medicalOfficeRepository = medicalOfficeRepository;
    }

    public Collection<MedicalOffice> findAll() {
        return medicalOfficeRepository.findAll();
    }

}
