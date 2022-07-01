package com.dh.proyect.dentalClinic.service.impl;

import com.dh.proyect.dentalClinic.dto.DentistDTO;
import com.dh.proyect.dentalClinic.entity.Dentist;
import com.dh.proyect.dentalClinic.repository.IDentistRepository;
import com.dh.proyect.dentalClinic.service.IDenstistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService implements IDenstistService {

    @Autowired
    IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public List<DentistDTO> dentistList(){
        List<DentistDTO> listDentistDTO = new ArrayList<>();
        List<Dentist> listDentists = dentistRepository.findAll();
        for (Dentist dentist:listDentists) {
            listDentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return listDentistDTO;
    }
    @Override
    public DentistDTO findDentistById(Long id){
        Optional<Dentist> dentist = dentistRepository.findById(id);
        DentistDTO dentistDTO = null;
        if (dentist.isPresent()){
            dentistDTO = mapper.convertValue(dentist, DentistDTO.class);
        }
        return dentistDTO;
    }
    @Override
    public Dentist saveDentist(Dentist dentist) {
        return dentistRepository.save(dentist);
    }
    @Override
    public Dentist updateDentist(Dentist dentist) {
        return dentistRepository.saveAndFlush(dentist);
    }
    @Override
    public void removeDentist(Long id) {
        dentistRepository.deleteById(id);
    }
}
