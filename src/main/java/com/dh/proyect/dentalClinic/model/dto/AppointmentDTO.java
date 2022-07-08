package com.dh.proyect.dentalClinic.model.dto;

import com.dh.proyect.dentalClinic.model.entity.Dentist;
import com.dh.proyect.dentalClinic.model.entity.Patient;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentDTO {
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private Long id;
    private LocalDate date;

    private LocalTime time;
    private Patient patient;
    private Dentist dentist;

    public AppointmentDTO() {
    }

    public AppointmentDTO(LocalDate date, LocalTime time, Patient patient, Dentist dentist) {
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
