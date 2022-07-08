package com.dh.proyect.dentalClinic.service.impl;


import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
import com.dh.proyect.dentalClinic.model.entity.Patient;
import com.dh.proyect.dentalClinic.repository.IPatientRepository;
import com.dh.proyect.dentalClinic.service.IPatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<PatientDTO> findAllPatients() {
        //mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        List<PatientDTO> listPatientDTO = new ArrayList<>();
        List<Patient> listPatients = patientRepository.findAll();
        for (Patient patient : listPatients) {
            listPatientDTO.add(mapper.convertValue(patient, PatientDTO.class));
        }
        return listPatientDTO;
    }

    /* ---------------------------------------------------------------------*/
    /*Find patient by id*/
    @Override
    public PatientDTO findPatientById(Long id) {
        return mapper.convertValue(patientRepository.findById(id), PatientDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Save patients*/
    @Override
    public PatientDTO savePatient(PatientDTO patientDTO) {
        Patient patientToSave = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.save(patientToSave);
        return mapper.convertValue(patientToSave, PatientDTO.class);
    }
    /* ---------------------------------------------------------------------*/
    /*Update patients*/
    @Override
    public PatientDTO updatePatient(PatientDTO patientDTO) {
        Patient patientToModify = mapper.convertValue(patientDTO, Patient.class);
        patientRepository.saveAndFlush(patientToModify);
        return mapper.convertValue(patientToModify, PatientDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Remove patients*/
    @Override
    public void removePatient(Long id) {
        patientRepository.deleteById(id);
    }
    /* ---------------------------------------------------------------------*/
}
