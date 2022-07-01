package com.dh.proyect.dentalClinic.controller;


import com.dh.proyect.dentalClinic.entity.Patient;
import com.dh.proyect.dentalClinic.service.impl.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    //Recibe la solicitud de la vista (hay que asociarlo con la vista), lo procesa y soluciona.
    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> patientList() {
        return patientService.patientList();
    }

    @PostMapping
    //Requestbody convierte el json en un objeto paciente
    //Postman en clase 21 a partir min 51
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    //Para hacerlo en postman, el id si o si hay que ageregarlo. Ya que pusimos que en paciente requiera un id para buscar.
    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    @GetMapping("/{id}") //No aplica a la vista
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id){
        if (patientService.findPatientById(id).isPresent()){
            return ResponseEntity.ok(patientService.findPatientById(id).get());
        }
        else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
       //Validamos que el paciente exista
        if(patientService.findPatientById(id).isPresent()){
            patientService.deletePatient(id);
            return ResponseEntity.ok("Deleted patient with id: " + id); //Check
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}