package com.beck.tobias.rockpaperscissor.persistence.domain;

import lombok.Data;
import lombok.Value;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * GameData
 */
@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    private Weapon player;
    private Weapon cpu;

    private GameStatus status;
    private Winner winner = Winner.NONE;


    public enum Winner {

           NONE, CPU, PLAYER, DRAW;

    }


}
