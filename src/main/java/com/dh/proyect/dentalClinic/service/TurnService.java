package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.entity.Turn;
import com.dh.proyect.dentalClinic.repository.ITurnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnService {
    //Em esta capa transformamos los DTO en clases de negocio
    @Autowired
    ITurnRepository ITurnRepository;

    public List<Turn> turnList(){
        return ITurnRepository.findAll();
    }

    public Optional<Turn> findTurnById(Long id){
        return ITurnRepository.findById(id);
    }

    public Turn saveTurn(Turn turn) {
        return ITurnRepository.save(turn);
    }

    public Turn updateTurn(Turn turn) {
        if (findTurnById(turn.getId()).isPresent()){
            return ITurnRepository.save(turn);
        }
        else
            return null;
    }

    public void removeTurn(Long id) {
        ITurnRepository.deleteById(id);
    }
}
