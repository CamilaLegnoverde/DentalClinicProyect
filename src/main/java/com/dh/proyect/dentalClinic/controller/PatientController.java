package com.dh.proyect.dentalClinic.controller;


import com.dh.proyect.dentalClinic.model.dto.PatientDTO;
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

    /* ---------------------------------------------------------------------*/
    /*List all patients*/
    @GetMapping()
    public List<PatientDTO> patientList() {
        return patientService.findAllPatients();
    }

    /* ---------------------------------------------------------------------*/
    /*Save patients*/
    @PostMapping
    //Requestbody convierte el json en un objeto paciente
    //Postman en clase 21 a partir min 51
    public PatientDTO savePatient(@RequestBody PatientDTO patientDTO){
        return patientService.savePatient(patientDTO);
    }

    /* ---------------------------------------------------------------------*/
    /*Update patients*/
    @PutMapping
    public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patientDTO){
        //Hacer variable respuesta para devolver la respuesta
        if(patientService.findPatientById(patientDTO.getId()) != null) {
            return ResponseEntity.ok(patientService.updatePatient(patientDTO));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
    public ResponseEntity<String> deletePatient(@PathVariable Long id){
        if(patientService.findPatientById(id) != null){
            patientService.removePatient(id);
            return ResponseEntity.ok("Deleted patient with id: " + id);
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    /* ---------------------------------------------------------------------*/
}