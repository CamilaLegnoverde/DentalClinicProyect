package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.entity.Dentist;
import com.dh.proyect.dentalClinic.repository.IDentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService{

    @Autowired
    IDentistRepository IDentistRepository;

    public List<Dentist> dentistList(){
        return IDentistRepository.findAll();
    }

    public Optional<Dentist> findDentistById(Long id){
        return IDentistRepository.findById(id);
    }

    public Dentist saveDentist(Dentist dentist) {
        return IDentistRepository.save(dentist);
    }

    public Dentist updateDentist(Dentist dentist) {
        if (findDentistById(dentist.getId()).isPresent()){
            return IDentistRepository.save(dentist);
        }
        else
            return null;
    }

    public void removeDentist(Long id) {
        IDentistRepository.deleteById(id);
    }
}
