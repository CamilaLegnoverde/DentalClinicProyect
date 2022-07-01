package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.dto.PatientDTO;
import com.dh.proyect.dentalClinic.entity.Patient;

import java.util.List;

public interface IPatientService {
    List<PatientDTO> patientList();

    PatientDTO findPatientById(Long id);

    Patient savePatient(Patient patientDTO);

    Patient updatePatient(Patient patientDTO);

    void removePatient(Long id);
}
