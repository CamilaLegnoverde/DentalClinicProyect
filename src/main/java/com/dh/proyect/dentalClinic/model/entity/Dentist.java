package com.dh.proyect.dentalClinic.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String surname;
    @Column
    private String name;
    @Column
    private String license;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dentist")
    private Set<Turn> turns = new HashSet<>();

    //Constructor
    public Dentist(){

    }

    public Dentist(Long id, String surname, String name, String license, Set<Turn> turns) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.license = license;
        this.turns = turns;
    }

    public Dentist(String surname, String name, String license, Set<Turn> turns) {
        this.surname = surname;
        this.name = name;
        this.license = license;
        this.turns = turns;
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

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }
}
