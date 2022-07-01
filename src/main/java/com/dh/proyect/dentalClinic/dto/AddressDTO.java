package com.dh.proyect.dentalClinic.dto;


public class AddressDTO {
    //Nos permite transportar información de una capa a la otra
    private String place;
    private String province;

    public AddressDTO() {
    }

    public AddressDTO(String place, String province) {
        this.place = place;
        this.province = province;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
