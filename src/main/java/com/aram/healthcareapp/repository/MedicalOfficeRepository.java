package com.aram.healthcareapp.repository;

import com.aram.healthcareapp.domain.MedicalOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalOfficeRepository extends JpaRepository<MedicalOffice, Integer> {
}
