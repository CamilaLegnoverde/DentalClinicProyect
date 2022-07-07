package com.dh.proyect.dentalClinic.model.dto;


public class DentistDTO {
    private Long id;
    private String surname;
    private String name;
    private String license;

    public DentistDTO() {
    }

    public DentistDTO(String surname, String name, String license) {
        this.surname = surname;
        this.name = name;
        this.license = license;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }
}
