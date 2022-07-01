package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.entity.Address;
import com.dh.proyect.dentalClinic.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AddressService {
    @Autowired
    IAddressRepository IAddressRepository;

    public List<Address> addressList(){
        return IAddressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id){
        return IAddressRepository.findById(id);
    }

    public Address saveAddress(Address address) {
        return IAddressRepository.save(address);
    }

    public Address updateAddress(Address address) {
        if (findAddressById(address.getId()).isPresent()){
            return IAddressRepository.save(address);
        }
        else
            return null;
    }

    public void removeAddress(Long id) {
        IAddressRepository.deleteById(id);
    }
}
