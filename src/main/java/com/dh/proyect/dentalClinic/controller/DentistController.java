package com.dh.proyect.dentalClinic.controller;

import com.dh.proyect.dentalClinic.model.dto.DentistDTO;
import com.dh.proyect.dentalClinic.model.entity.Dentist;
import com.dh.proyect.dentalClinic.service.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    public DentistService dentistService;

    /* ---------------------------------------------------------------------*/
    /*List all dentists*/
    @GetMapping
    public List<DentistDTO> dentistList(){
        return dentistService.dentistList();
    }

    /* ---------------------------------------------------------------------*/
    /*Find dentist by id*/

    @GetMapping("/{id}") //COn esto no estamos usando el html, chequear eso
    public ResponseEntity<DentistDTO> findDentistById(@PathVariable Long id){
        if (dentistService.findDentistById(id) != null){
            return ResponseEntity.ok(dentistService.findDentistById(id));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /* ---------------------------------------------------------------------*/
    /*Save dentists*/
    @PostMapping
    public DentistDTO saveDentist(@RequestBody DentistDTO dentistDTO){
        return dentistService.saveDentist(dentistDTO);
    }

    /* ---------------------------------------------------------------------*/
    /*Update dentists*/
    @PutMapping
    public ResponseEntity<DentistDTO> updateDentist(@RequestBody DentistDTO dentistDTO){
        if (dentistService.findDentistById(dentistDTO.getId()) != null) {
            return ResponseEntity.ok(dentistService.updateDentist(dentistDTO));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /* ---------------------------------------------------------------------*/
    /*Delete dentist*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDentist(@PathVariable Long id){
        String repsonse = "Error removing the dentist";
        if (dentistService.findDentistById(id) != null){
            dentistService.removeDentist(id);
            return ResponseEntity.ok("Deleted dentist with id: " + id);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
