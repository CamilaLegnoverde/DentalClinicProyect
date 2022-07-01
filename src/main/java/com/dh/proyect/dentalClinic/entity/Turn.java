package com.dh.proyect.dentalClinic.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "Turns")
public class Turn {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;


    //Constructor
    public Turn() {
    }

    public Turn(Long id, LocalDate date, Patient patient, Dentist dentist) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }

    public Turn(LocalDate date, Patient patient, Dentist dentist) {
        this.date = date;
        this.patient = patient;
        this.dentist = dentist;
    }

    //Getters and setters
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
