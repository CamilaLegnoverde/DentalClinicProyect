package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.model.dto.AppointmentDTO;

import java.util.List;

public interface IAppointmentService {

    List<AppointmentDTO> appointmentList();

    AppointmentDTO findAppointmentById(Long id);

    AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO);

    AppointmentDTO updateAppointment(AppointmentDTO appointmentDTO);

    void removeAppointment(Long id);
}
