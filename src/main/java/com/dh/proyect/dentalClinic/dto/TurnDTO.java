package com.dh.proyect.dentalClinic.dto;

import com.dh.proyect.dentalClinic.entity.Dentist;
import com.dh.proyect.dentalClinic.entity.Patient;
import java.time.LocalDate;

public class TurnDTO {
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
