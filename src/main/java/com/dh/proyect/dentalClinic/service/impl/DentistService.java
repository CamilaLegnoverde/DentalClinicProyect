package com.dh.proyect.dentalClinic.service.impl;

import com.dh.proyect.dentalClinic.model.dto.DentistDTO;
import com.dh.proyect.dentalClinic.model.entity.Dentist;
import com.dh.proyect.dentalClinic.repository.IDentistRepository;
import com.dh.proyect.dentalClinic.service.IDenstistService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DentistService implements IDenstistService {

    @Autowired
    IDentistRepository dentistRepository;
    @Autowired
    ObjectMapper mapper;
    /* ---------------------------------------------------------------------*/
    /*List all dentists*/
    @Override
    public List<DentistDTO> dentistList(){
        List<DentistDTO> listDentistDTO = new ArrayList<>();
        List<Dentist> listDentists = dentistRepository.findAll();
        for (Dentist dentist:listDentists) {
            listDentistDTO.add(mapper.convertValue(dentist, DentistDTO.class));
        }
        return listDentistDTO;
    }

    /* ---------------------------------------------------------------------*/
    /*Find dentists by id*/
    @Override
    public DentistDTO findDentistById(Long id){
        return mapper.convertValue(dentistRepository.findById(id), DentistDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Save dentists*/
    @Override
    public DentistDTO saveDentist(DentistDTO dentistDTO) {
        Dentist dentistToSave = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.save(dentistToSave);
        return mapper.convertValue(dentistToSave, DentistDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Update dentists*/
    @Override
    public DentistDTO updateDentist(DentistDTO dentistDTO) {
        Dentist dentistToModify = mapper.convertValue(dentistDTO, Dentist.class);
        dentistRepository.saveAndFlush(dentistToModify);
        return mapper.convertValue(dentistToModify, DentistDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Remove dentists by id*/
    @Override
    public void removeDentist(Long id) {
        dentistRepository.deleteById(id);
    }
    /* ---------------------------------------------------------------------*/
}
