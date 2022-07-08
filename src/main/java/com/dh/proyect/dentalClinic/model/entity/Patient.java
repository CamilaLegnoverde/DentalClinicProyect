package com.dh.proyect.dentalClinic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String identification;
    @Column
    private LocalDate admissionDate;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address; //Bidireccional

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();

    //Constructor
    public Patient() {
    }

    public Patient(Long id, String surname, String name, String email, String identification, LocalDate admissionDate, Address address, Set<Appointment> appointments) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.identification = identification;
        this.admissionDate = admissionDate;
        this.address = address;
        this.appointments = appointments;
    }

    public Patient(String surname, String name, String email, String identification, LocalDate admissionDate, Address address) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.identification = identification;
        this.admissionDate = admissionDate;
        this.address = address;
    }
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Appointment> getTurns() {
        return appointments;
    }

    public void setTurns(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
