package com.dh.proyect.dentalClinic.model.dto;

import com.dh.proyect.dentalClinic.model.entity.Dentist;
import com.dh.proyect.dentalClinic.model.entity.Patient;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class TurnDTO {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDate date;
    private Patient patient;
    private Dentist dentist;

    public TurnDTO() {
    }

    public TurnDTO(LocalDate date, Patient patient, Dentist dentist) {
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
