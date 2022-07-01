package com.dh.proyect.dentalClinic.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientDTO {

    private Long id;
    private String surname;
    private String name;
    private String email;
    private String identification;

    //Constructor
    public PatientDTO() {
    }

    public PatientDTO(Long id, String surname, String name, String email, String identification) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.identification = identification;
    }
    //Getters and setters

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
}
