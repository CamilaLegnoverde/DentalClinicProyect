package com.dh.proyect.dentalClinic.service.impl;

import com.dh.proyect.dentalClinic.dto.PatientDTO;
import com.dh.proyect.dentalClinic.entity.Patient;
import com.dh.proyect.dentalClinic.repository.IPatientRepository;
import com.dh.proyect.dentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {
    //Capa que transforma los DTO en las clases de negocio
    @Autowired
    IPatientRepository patientRepository;
    @Autowired
    ObjectMapper mapper;

    /* ---------------------------------------------------------------------*/
    /*List all patients*/
    @Override
    public List<PatientDTO> patientList() {
        List<PatientDTO> listPatientDTO = new ArrayList<>();
        List<Patient> listPatients = patientRepository.findAll();
        for (Patient patient:listPatients) {
            listPatientDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return listPatientDTO;
    }

    /* ---------------------------------------------------------------------*/
    /*Find patient by id*/
    @Override
    public PatientDTO findPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        PatientDTO patientDTO = null;
        if (patient.isPresent()){
            patientDTO = mapper.convertValue(patient, PatientDTO.class);
        }
        return patientDTO;
        //Si es null devuelve null
    }

    /* ---------------------------------------------------------------------*/
    /*Save patients*/
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }
    /* ---------------------------------------------------------------------*/
    /*Update patients*/
    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }

    /* ---------------------------------------------------------------------*/
    /*Remove patients*/
    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }
    /* ---------------------------------------------------------------------*/
}
