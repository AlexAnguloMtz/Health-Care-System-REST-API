package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Doctor;
import com.aram.healthcareapp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    public Collection<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Transactional
    public Optional<Doctor> findById(Integer id) {
        return doctorRepository.findById(id);
    }

    @Transactional
    public Doctor save(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Transactional
    public void deleteDoctor(Integer id) {
        doctorRepository.deleteById(id);
    }

    public Collection<Doctor> findBySpecialityId(Integer specialityId) {
        return doctorRepository.findBySpecialityId(specialityId);
    }
}
