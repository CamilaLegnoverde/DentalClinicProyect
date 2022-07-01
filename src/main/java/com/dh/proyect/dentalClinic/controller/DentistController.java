package com.dh.proyect.dentalClinic.controller;

import com.dh.proyect.dentalClinic.entity.Dentist;
import com.dh.proyect.dentalClinic.service.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {
    @Autowired
    public DentistService dentistService;

    @GetMapping
    public List<Dentist> dentistList(){
        return dentistService.dentistList();
    }

    @GetMapping("/{id}") //COn esto no estamos usando el html, chequear eso
    public Dentist findDentistById(@PathVariable Long id, Model model){

        Dentist dentist = dentistService.findDentistById(id).get();

        model.addAttribute("id", dentist.getId());
        model.addAttribute("surname", dentist.getSurname());

        return dentist;
    }
    @PostMapping
    public Dentist saveDentist(@RequestBody Dentist dentist){
        return dentistService.saveDentist(dentist);
    }

    @PutMapping
    public Dentist updateDentist(@RequestBody Dentist dentist){
        return dentistService.updateDentist(dentist);
    }

    @DeleteMapping("/{id}")
    public String deleteDentist(@PathVariable Long id){
        String repsonse = "Error removing the dentist";
        if (dentistService.findDentistById(id).isPresent()){
            dentistService.removeDentist(id);
            repsonse = "The dentist with id: " + id + " has been removed";
        }
        return repsonse;
    }
}
