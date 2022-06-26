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

    public Optional<Doctor> findById(Integer id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Integer id) {
    }
}
