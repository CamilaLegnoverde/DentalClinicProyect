package com.dh.proyect.dentalClinic.entity;

import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String street;
    @Column
    private int number;
    @Column
    private String city;
    @Column
    private String province;

    @OneToOne(mappedBy = "address")
    private Patient patient;

    //Constructor
    public Address() {
    }

    public Address(Long id, String street, int number, String city, String province, Patient patient) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.province = province;
        this.patient = patient;
    }

    public Address(String street, int number, String city, String province, Patient patient) {
        this.street = street;
        this.number = number;
        this.city = city;
        this.province = province;
        this.patient = patient;
    }

    //Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
