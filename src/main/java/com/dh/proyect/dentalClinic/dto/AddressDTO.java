package com.dh.proyect.dentalClinic.dto;


public class AddressDTO {
    //Nos permite transportar información de una capa a la otra
    private String city;
    private String province;

    public AddressDTO() {
    }

    public AddressDTO(String city, String province) {
        this.city = city;
        this.province = province;
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
}
