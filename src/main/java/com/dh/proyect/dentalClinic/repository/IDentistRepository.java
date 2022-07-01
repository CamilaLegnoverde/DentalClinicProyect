package com.dh.proyect.dentalClinic.repository;

import com.dh.proyect.dentalClinic.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
}
