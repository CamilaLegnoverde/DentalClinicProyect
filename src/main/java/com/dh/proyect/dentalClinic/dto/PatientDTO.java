package com.dh.proyect.dentalClinic.dto;


public class PatientDTO {

    private Long id;
    private String surname;
    private String name;
    private String email;
    private String identification;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String surname, String name, String email, String identification) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.identification = identification;
    }

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
