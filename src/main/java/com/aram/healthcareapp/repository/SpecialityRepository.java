package com.aram.healthcareapp.repository;

import com.aram.healthcareapp.domain.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Integer> {
    Optional<Speciality> findByName(String name);
}
