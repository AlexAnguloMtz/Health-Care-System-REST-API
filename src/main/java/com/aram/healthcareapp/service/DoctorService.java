package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Optional;
import static com.aram.healthcareapp.domain.ErrorCode.DOCTOR_DOES_NOT_EXIST;

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

    public Doctor findById(Integer id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        return doctorOptional.orElseThrow(
                () -> new RuntimeException(DOCTOR_DOES_NOT_EXIST.toString()));
    }

}
