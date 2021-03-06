package com.dh.proyect.dentalClinic.repository;

import com.dh.proyect.dentalClinic.model.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
