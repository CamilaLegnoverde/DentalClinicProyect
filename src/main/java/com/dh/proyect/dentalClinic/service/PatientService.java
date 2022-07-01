package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.entity.Patient;
import com.dh.proyect.dentalClinic.repository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService{
    @Autowired
    IPatientRepository IPatientRepository;

    //Implementamos método para listar los pacientes
    public List<Patient> patientList(){
        return IPatientRepository.findAll();
    }

    //Implementamos el método de buscar el paciente según su id
    public Optional<Patient> findPatientById(Long id){
        //Devolvemos opcional, En el caso de devolver paciente le ponemos un .get al findById
        return IPatientRepository.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return IPatientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        //Verificamos que el paciente exista
        if (findPatientById(patient.getId()).isPresent()){
           return IPatientRepository.save(patient);
        }
        else
            return null;
    }

    public void deletePatient(Long id) {
        IPatientRepository.deleteById(id);
    }
}
