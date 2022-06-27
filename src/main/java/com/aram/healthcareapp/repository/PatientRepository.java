package com.aram.healthcareapp.repository;

import com.aram.healthcareapp.domain.Patient;
import com.aram.healthcareapp.domain.SocialSecurityNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<Patient> findBySocialSecurityNumber(SocialSecurityNumber socialSecurityNumber);
}
