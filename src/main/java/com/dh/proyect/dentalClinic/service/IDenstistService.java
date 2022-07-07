package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.model.dto.DentistDTO;
import com.dh.proyect.dentalClinic.model.entity.Dentist;

import java.util.List;

public interface IDenstistService {

    List<DentistDTO> dentistList();

    DentistDTO findDentistById(Long id);

    DentistDTO saveDentist(DentistDTO dentistDTO);

    DentistDTO updateDentist(DentistDTO dentistDTO);

    void removeDentist(Long id);
}
