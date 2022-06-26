package com.aram.healthcareapp.repository;

import com.aram.healthcareapp.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    Collection<Appointment> findAllByDoctorId(Integer doctorId);
}
