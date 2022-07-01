package com.dh.proyect.dentalClinic.repository;

import com.dh.proyect.dentalClinic.entity.Turn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnRepository extends JpaRepository<Turn, Long> {
}
