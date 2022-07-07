package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPatientService {
    List<PatientDTO> findAllPatients();

    PatientDTO findPatientById(Long id);

    PatientDTO savePatient(PatientDTO patientDTO);

    PatientDTO updatePatient(PatientDTO patientDTO);

    void removePatient(Long id);
}
