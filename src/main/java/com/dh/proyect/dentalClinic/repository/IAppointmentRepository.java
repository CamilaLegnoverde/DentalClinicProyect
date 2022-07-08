package com.dh.proyect.dentalClinic.repository;

import com.dh.proyect.dentalClinic.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
