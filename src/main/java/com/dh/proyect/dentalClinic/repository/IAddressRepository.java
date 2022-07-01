package com.dh.proyect.dentalClinic.repository;

import com.dh.proyect.dentalClinic.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {
}
