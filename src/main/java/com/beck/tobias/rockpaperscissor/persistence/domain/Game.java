package com.beck.tobias.rockpaperscissor.persistence.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

/**
 * GameData
 */
@Data
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gameId;

    private Weapon playerWeapon;
    private Weapon cpuWeapon;

    private GameState status = GameState.WAIT_FOR_PLAYER_INPUT;
    private Winner winner;


    /**
     * Starts a Game with Player Weapon as Weapon for the Game
     *
     * @param playerWeapon Rock, Paper or Scissor
     */
    public void play(Weapon playerWeapon) {
        //if winner is set, than game was played and you dont need a second winner
        if (winner == null) {
            this.cpuWeapon = randomWeapon();
            this.playerWeapon = playerWeapon;
            determineWinner();
            status = GameState.FINISH;
        }
    }

    /**
     * Randomly choose a Weapon
     *
     * @return a random Weapon
     */
    private Weapon randomWeapon() {
        return Weapon.values()[new Random().nextInt(Weapon.values().length)];
    }

    /**
     * Logic of the Game, find out who won the Game and sets winner variable in Game
     *
     */
    public void determineWinner() {

        if (playerWeapon != null && cpuWeapon != null && winner == null) {
            switch (playerWeapon) {

                case ROCK:
                    if (cpuWeapon.equals(Weapon.ROCK)) {
                        setWinner(Winner.DRAW);
                        break;
                    } else if (cpuWeapon.equals(Weapon.PAPER)) {
                        setWinner(Winner.CPU);
                        break;
                    } else if (cpuWeapon.equals(Weapon.SCISSOR)) {
                        setWinner(Winner.PLAYER);
                        break;
                    }
                case PAPER:
                    if (cpuWeapon.equals(Weapon.ROCK)) {
                        setWinner(Winner.PLAYER);
                        break;
                    } else if (cpuWeapon.equals(Weapon.PAPER)) {
                        setWinner(Winner.DRAW);
                        break;
                    } else if (cpuWeapon.equals(Weapon.SCISSOR)) {
                        setWinner(Winner.CPU);
                        break;
                    }
                case SCISSOR:
                    if (cpuWeapon.equals(Weapon.ROCK)) {
                        setWinner(Winner.CPU);
                        break;
                    } else if (cpuWeapon.equals(Weapon.PAPER)) {
                        setWinner(Winner.PLAYER);
                        break;
                    } else if (cpuWeapon.equals(Weapon.SCISSOR)) {
                        setWinner(Winner.DRAW);
                        break;
                    }
            }

        }
    }

}
