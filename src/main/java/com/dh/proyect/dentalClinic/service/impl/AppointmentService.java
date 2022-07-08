package com.dh.proyect.dentalClinic.service.impl;

import com.dh.proyect.dentalClinic.model.dto.AppointmentDTO;
import com.dh.proyect.dentalClinic.model.entity.Appointment;
import org.apache.log4j.Logger;
import com.dh.proyect.dentalClinic.repository.IAppointmentRepository;
import com.dh.proyect.dentalClinic.service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService implements IAppointmentService {
    //Em esta capa transformamos los DTO en clases de negocio
    private static final Logger logger = Logger.getLogger(Test.class);
    @Autowired
    IAppointmentRepository turnRepository;
    @Autowired
    DentistService dentistService;
    @Autowired
    PatientService patientService;
    @Autowired
    ObjectMapper mapper;
    /* ---------------------------------------------------------------------*/
    /*List all appointments*/
    @Override
    public List<AppointmentDTO> appointmentList(){
        List<AppointmentDTO> listAppointmentDTO = new ArrayList<>();
        List<Appointment> listAppointments = turnRepository.findAll();
        for (Appointment appointment : listAppointments) {
            listAppointmentDTO.add(mapper.convertValue(appointment, AppointmentDTO.class));
        }
        return listAppointmentDTO;
    }

    /* ---------------------------------------------------------------------*/
    /*Find appointments by id*/
    @Override
    public AppointmentDTO findAppointmentById(Long id){
        return mapper.convertValue(turnRepository.findById(id), AppointmentDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Save appointments*/
    @Override
    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {
        //Obtenemos el id del dentista
        dentistService.findDentistById(appointmentDTO.getDentist().getId());
        //Obtenemos el id del paciente
        patientService.findPatientById(appointmentDTO.getPatient().getId());
        Appointment appointmentToSave = mapper.convertValue(appointmentDTO, Appointment.class);
        //Hacemos una lista para recorrer y verificar que el turno no existe
        List<Appointment> listAllAppointments = turnRepository.findAll();
        for (Appointment appointment : listAllAppointments) {
            if (appointmentDTO.getDate().equals(appointment.getDate())) {
                logger.info("The date and time entered is already reserved");
            }
        }
        turnRepository.save(appointmentToSave);
        return mapper.convertValue(appointmentToSave, AppointmentDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Update appointments*/
    @Override
    public AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointmentToModify = mapper.convertValue(appointmentDTO, Appointment.class);
        turnRepository.saveAndFlush(appointmentToModify);
        return mapper.convertValue(appointmentToModify, AppointmentDTO.class);
    }

    /* ---------------------------------------------------------------------*/
    /*Remove appointments*/
    @Override
    public void removeAppointment(Long id) {
        turnRepository.deleteById(id);
    }
    /* ---------------------------------------------------------------------*/
}
