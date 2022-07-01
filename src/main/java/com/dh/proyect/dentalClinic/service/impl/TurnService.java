package com.dh.proyect.dentalClinic.service.impl;

import com.dh.proyect.dentalClinic.dto.TurnDTO;
import com.dh.proyect.dentalClinic.entity.Turn;
import com.dh.proyect.dentalClinic.repository.ITurnRepository;
import com.dh.proyect.dentalClinic.service.ITurnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnService implements ITurnService {
    //Em esta capa transformamos los DTO en clases de negocio
    @Autowired
    ITurnRepository turnRepository;
    @Autowired
    ObjectMapper mapper;
    @Override
    public List<TurnDTO> turnList(){
        List<TurnDTO> listTurnDTO = new ArrayList<>();
        List<Turn> listTurns = turnRepository.findAll();
        for (Turn turn:listTurns) {
            listTurnDTO.add(mapper.convertValue(turn, TurnDTO.class));
        }
        return listTurnDTO;
    }
    @Override
    public TurnDTO findTurnById(Long id){
        Optional<Turn> turn = turnRepository.findById(id);
        TurnDTO turnDTO = null;
        if (turn.isPresent()){
            turnDTO = mapper.convertValue(turn, TurnDTO.class);
        }
        return turnDTO;
    }
    @Override
    public Turn saveTurn(Turn turn) {
        return turnRepository.save(turn);
    }
    @Override
    public Turn updateTurn(Turn turn) {
        return turnRepository.saveAndFlush(turn);
    }
    @Override
    public void removeTurn(Long id) {
        turnRepository.deleteById(id);
    }
}