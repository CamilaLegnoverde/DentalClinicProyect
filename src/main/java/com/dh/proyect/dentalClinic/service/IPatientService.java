package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.dto.PatientDTO;
import com.dh.proyect.dentalClinic.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> patientList();

    PatientDTO findPatientById(Long id);

    Patient savePatient(Patient patient);

    Patient updatePatient(Patient patient);

    void removePatient(Long id);
}
