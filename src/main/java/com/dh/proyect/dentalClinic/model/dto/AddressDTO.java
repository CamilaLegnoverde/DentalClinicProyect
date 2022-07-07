package com.dh.proyect.dentalClinic.model.dto;


public class AddressDTO {
    //Nos permite transportar información de una capa a la otra
    private Long id;
    private int number;
    private String street;
    private String city;
    private String province;

    public AddressDTO() {
    }

    public AddressDTO(int number, String street, String city, String province) {
        this.number = number;
        this.street = street;
        this.city = city;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
