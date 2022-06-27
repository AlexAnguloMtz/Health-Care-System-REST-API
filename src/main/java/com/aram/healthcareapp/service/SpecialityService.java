package com.aram.healthcareapp.service;

import com.aram.healthcareapp.domain.Speciality;
import com.aram.healthcareapp.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class SpecialityService {

    private final SpecialityRepository specialityRepository;

    @Autowired
    public SpecialityService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Transactional
    public Collection<Speciality> findAll() {
        return specialityRepository.findAll();
    }

    @Transactional
    public Optional<Speciality> findById(Integer id) {
        return specialityRepository.findById(id);
    }

    @Transactional
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Transactional
    public void deleteById(Integer id) {
        specialityRepository.deleteById(id);
    }
    public Optional<Speciality> findByName(String name) {
        return specialityRepository.findByName(name);
    }


}
