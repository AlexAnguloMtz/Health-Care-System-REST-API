package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.ErrorCode;
import com.aram.healthcareapp.domain.MedicalOffice;
import com.aram.healthcareapp.repository.MedicalOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import static com.aram.healthcareapp.domain.ErrorCode.MEDICAL_OFFICE_DOES_NOT_EXIST;

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

    public MedicalOffice findById(Integer id) {
        Optional<MedicalOffice> medicalOfficeOptional = medicalOfficeRepository.findById(id);
        return medicalOfficeOptional.orElseThrow(
                () -> new RuntimeException(MEDICAL_OFFICE_DOES_NOT_EXIST.toString()));
    }
}
