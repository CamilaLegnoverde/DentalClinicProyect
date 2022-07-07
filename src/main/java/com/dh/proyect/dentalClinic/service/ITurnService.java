package com.dh.proyect.dentalClinic.service;

import com.dh.proyect.dentalClinic.model.dto.TurnDTO;
import com.dh.proyect.dentalClinic.model.entity.Turn;

import java.util.List;

public interface ITurnService {

    List<TurnDTO> turnList();

    TurnDTO findTurnById(Long id);

    Turn saveTurn(Turn turn);

    Turn updateTurn(Turn turn);

    void removeTurn(Long id);
}
