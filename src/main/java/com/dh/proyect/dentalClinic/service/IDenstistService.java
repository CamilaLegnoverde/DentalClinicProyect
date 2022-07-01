package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.dto.DentistDTO;
import com.dh.proyect.dentalClinic.entity.Dentist;

import java.util.List;

public interface IDenstistService {

    List<DentistDTO> dentistList();

    DentistDTO findDentistById(Long id);

    Dentist saveDentist(Dentist dentist);

    Dentist updateDentist(Dentist dentist);

    void removeDentist(Long id);
}
