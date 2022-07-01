package com.dh.proyect.dentalClinic.controller;


import com.dh.proyect.dentalClinic.dto.PatientDTO;
import com.dh.proyect.dentalClinic.entity.Patient;
import com.dh.proyect.dentalClinic.service.IPatientService;
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
    private IPatientService patientService;

    /* ---------------------------------------------------------------------*/
    /*List all patients*/
    @GetMapping
    public List<PatientDTO> patientList() {
        return patientService.patientList();
    }

    /* ---------------------------------------------------------------------*/
    /*Save patients*/
    @PostMapping
    //Requestbody convierte el json en un objeto paciente
    //Postman en clase 21 a partir min 51
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.savePatient(patient);
    }

    /* ---------------------------------------------------------------------*/
    /*Update patients*/
    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient){
        return patientService.updatePatient(patient);
    }

    /* ---------------------------------------------------------------------*/
    /*Find patient by id*/
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Long id){
        if (patientService.findPatientById(id) != null){
            return ResponseEntity.ok(patientService.findPatientById(id));
        }
        else
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /* ---------------------------------------------------------------------*/
    /*Delete patient*/
    @DeleteMapping("/{id}")
    public ResponseEntity deletePatient(@PathVariable Long id){
        if(patientService.findPatientById(id) != null){
            patientService.removePatient(id);
            return ResponseEntity.ok("Deleted patient with id: " + id); //Check
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    /* ---------------------------------------------------------------------*/
}